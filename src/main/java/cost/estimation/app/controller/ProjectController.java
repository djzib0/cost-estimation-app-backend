package cost.estimation.app.controller;

import cost.estimation.app.entity.Project;
import cost.estimation.app.error.ProjectNotFoundException;
import cost.estimation.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Project getProject(@PathVariable("id") Long projectId) throws ProjectNotFoundException {
        return projectService.getProject(projectId);
    }

    @PostMapping("data/projects/add")
    public Project addProject(@RequestBody Project newProject, @RequestParam(required = true) Long projectTypeId) {
        return projectService.addProject(newProject, projectTypeId);
    }

    @PutMapping("data/projects/edit")
    public Project editProject(@RequestBody Project project, @RequestParam(required = true) Long projectTypeId) {
        return projectService.editProject(project, projectTypeId);
    }

    @DeleteMapping("data/projects/delete/{id}")
    public void deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);
    }
}
