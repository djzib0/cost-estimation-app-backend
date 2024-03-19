package cost.estimation.app.service;

import cost.estimation.app.entity.ProjectOperation;
import cost.estimation.app.repository.ProjectOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectOperationService {

    @Autowired
    private ProjectOperationRepository projectOperationRepository;

    public List<ProjectOperation> getAllProjectOperations() {
        return  projectOperationRepository.findAll();
    }

    public List<ProjectOperation> getAllProjectOperationsByProjectId(Long projectId) {
        return projectOperationRepository.findAllByProjectId(projectId);
    }
}
