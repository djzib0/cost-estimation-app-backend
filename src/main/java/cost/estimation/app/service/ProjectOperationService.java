package cost.estimation.app.service;

import cost.estimation.app.entity.ProductionHourType;
import cost.estimation.app.entity.ProjectOperation;
import cost.estimation.app.repository.ProductionHourTypeRepository;
import cost.estimation.app.repository.ProjectOperationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return projectOperationRepository.findAllByProjectId(projectId);
    }

    public ProjectOperation addProjectOperation(ProjectOperation newProjectOperation, Long projectId) {
        newProjectOperation.setProjectId(projectId);

        // get operation type name by id
        ProductionHourType productionHourType = productionHourTypeRepository.findById(newProjectOperation.getOperationHourTypeId()).orElseThrow();

        newProjectOperation.setOperationHourTypeName(productionHourType.getProductionHourTypeName());

        Double pricePerHour = productionHourType.getProductionHourTypePricePerHour();
        newProjectOperation.setOperationPricePerHour(pricePerHour);
        newProjectOperation.setTotalValue(newProjectOperation.getQuantity() * pricePerHour);

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
}
