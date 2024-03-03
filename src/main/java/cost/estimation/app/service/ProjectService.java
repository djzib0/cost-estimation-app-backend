package cost.estimation.app.service;

import cost.estimation.app.entity.Project;
import cost.estimation.app.entity.ProjectType;
import cost.estimation.app.repository.ProjectRepository;
import cost.estimation.app.repository.ProjectTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow();
    }

    public Project addProject(Project newProject, Long projectTypeId) {
        ProjectType projectType = projectTypeRepository.findById(projectTypeId).orElseThrow();
        newProject.setProjectType(projectType);
        System.out.println("I'm here");

        return projectRepository.save(newProject);
    }

    @Transactional
    public Project editProject(Project project, Long projectTypeId) {
        Project editedProject = projectRepository.findById(project.getProjectId()).orElseThrow();
        ProjectType projectType = projectTypeRepository.findById(projectTypeId).orElseThrow();

        editedProject.setProjectNumber(project.getProjectNumber());
        editedProject.setProjectClientNumber(project.getProjectClientNumber());
        editedProject.setProjectType(projectType);
        editedProject.setTitle(project.getTitle());
        editedProject.setDrawingNumber(project.getDrawingNumber());
        editedProject.setMaterialMargin(project.getMaterialMargin());
        editedProject.setOutsourcingMargin(project.getOutsourcingMargin());
        editedProject.setSalesMargin(project.getSalesMargin());

        return editedProject;
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
