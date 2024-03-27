package cost.estimation.app.service;

import cost.estimation.app.entity.ProductionHourType;
import cost.estimation.app.entity.ProjectOperation;
import cost.estimation.app.repository.ProductionHourTypeRepository;
import cost.estimation.app.repository.ProjectOperationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectOperationService {

    @Autowired
    private ProjectOperationRepository projectOperationRepository;

    @Autowired
    private ProductionHourTypeRepository productionHourTypeRepository;

    public List<ProjectOperation> getAllProjectOperations() {
        return  projectOperationRepository.findAll();
    }

    public List<ProjectOperation> getAllProjectOperationsByProjectId(Long projectId) {
        return projectOperationRepository.findAllByProjectId(projectId, Sort.by(Sort.Direction.ASC, "positionInProject"));
    }

    public ProjectOperation addProjectOperation(ProjectOperation newProjectOperation, Long projectId) {

        newProjectOperation.setProjectId(projectId);

        // get operation type name by id
        ProductionHourType productionHourType = productionHourTypeRepository.findById(newProjectOperation.getOperationHourTypeId()).orElseThrow();

        newProjectOperation.setOperationHourTypeName(productionHourType.getProductionHourTypeName());

        Double pricePerHour = productionHourType.getProductionHourTypePricePerHour();
        newProjectOperation.setOperationPricePerHour(pricePerHour);
        newProjectOperation.setTotalValue(newProjectOperation.getQuantity() * pricePerHour);

        // set position in project
        // first count the existing operations in the project
        Long numberOfProjectOperationsInProject = projectOperationRepository.findAllByProjectId(projectId, Sort.by(Sort.Direction.ASC, "positionInProject")).stream().count();
        List<ProjectOperation> listOfOperations = projectOperationRepository.findAllByProjectId(projectId, Sort.by(Sort.Direction.ASC, "positionInProject")).stream().toList();
        ProjectOperation operationWithMaxPosition = listOfOperations.stream().max(Comparator.comparingLong(ProjectOperation::getPositionInProject)).get();
        // then set the position for a new operation with "count + 1"
        newProjectOperation.setPositionInProject(operationWithMaxPosition.getPositionInProject() + 1);
        System.out.println(numberOfProjectOperationsInProject + " number of items");

        return projectOperationRepository.save(newProjectOperation);
    }

    @Transactional
    public ProjectOperation editProjectOperation(ProjectOperation projectOperation, Long projectId) {
        ProjectOperation editedProjectOperation = projectOperationRepository.findById(projectOperation.getProjectOperationId()).orElseThrow();

        editedProjectOperation.setOperationTitle(projectOperation.getOperationTitle());
        editedProjectOperation.setQuantity(projectOperation.getQuantity());

        // get operation type name by id
        ProductionHourType productionHourType = productionHourTypeRepository.findById(projectOperation.getOperationHourTypeId()).orElseThrow();

        Double pricePerHour = productionHourType.getProductionHourTypePricePerHour();
        editedProjectOperation.setOperationPricePerHour(pricePerHour);
        editedProjectOperation.setTotalValue(projectOperation.getQuantity() * pricePerHour);


        editedProjectOperation.setOperationHourTypeId(productionHourType.getProductionHourTypeId());
        editedProjectOperation.setOperationHourTypeName(productionHourType.getProductionHourTypeName());
        editedProjectOperation.setOperationPricePerHour(productionHourType.getProductionHourTypePricePerHour());
        editedProjectOperation.setOperationPricePerHour(productionHourType.getProductionHourTypePricePerHour());

        editedProjectOperation.setRemark(projectOperation.getRemark());
        editedProjectOperation.setProjectId(projectId);

        return editedProjectOperation;
    }

    public void deleteProjectOperation(Long projectOperationId) {
        projectOperationRepository.deleteById(projectOperationId);
    }

    @Transactional
    public void increaseProjectOperationPosition(Long editedOperationId, Long switchedOperationId) {
        ProjectOperation editedProjectOperation = projectOperationRepository.findById(editedOperationId).orElseThrow();
        ProjectOperation switchedProjectOperation = projectOperationRepository.findById(switchedOperationId).orElseThrow();

        // take a position to replace with and store it in a variable
        Long newPositionForEditedProjectOperation = switchedProjectOperation.getPositionInProject();

        // new position for switched operation is a current position
        // of edited operation
        switchedProjectOperation.setPositionInProject(editedProjectOperation.getPositionInProject());

        // new position of the edited operation is a previous position
        // of the switched position stored in the variable
        editedProjectOperation.setPositionInProject(newPositionForEditedProjectOperation);

        // saving both entries
        projectOperationRepository.save(editedProjectOperation);
        projectOperationRepository.save(switchedProjectOperation);
    }
}
