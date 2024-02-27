package cost.estimation.app.controller;

import cost.estimation.app.entity.Project;
import cost.estimation.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("data/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("data/projects/{id}")
    public Project getProject(@PathVariable("id") Long projectId) {
        return projectService.getProject(projectId);
    }
}
