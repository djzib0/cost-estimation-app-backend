package cost.estimation.app.service;

import cost.estimation.app.entity.Project;
import cost.estimation.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow();
    }
}
