package cost.estimation.app.controller;

import cost.estimation.app.entity.Project;
import cost.estimation.app.entity.ProjectOperation;
import cost.estimation.app.service.ProjectOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectOperationController {

    @Autowired
    private ProjectOperationService projectOperationService;

    @GetMapping("data/operations/all")
    public List<ProjectOperation> getAllProjectOperations() {
        return projectOperationService.getAllProjectOperations();
    }

    @GetMapping("data/project/{id}/operations/all")
    public List<ProjectOperation> getAllProjectOperationsByProjectId(@PathVariable("id") Long projectId) {
        return projectOperationService.getAllProjectOperationsByProjectId(projectId);
    }

    @PostMapping("data/operations/add")
    public ProjectOperation addProjectOperation(@RequestBody ProjectOperation newProjectOperation,
                                                @RequestParam(required = true) Long projectId) {
        return projectOperationService.addProjectOperation(newProjectOperation, projectId);
    }

    @PutMapping("data/operations/edit")
    public ProjectOperation editProjectOperation(
            @RequestBody ProjectOperation projectOperation,
            @RequestParam(required = true) Long projectId) {
        return projectOperationService.editProjectOperation(projectOperation, projectId);
    }

    @DeleteMapping("data/operations/delete/{id}")
    public void deleteProjectOperation(@PathVariable("id") Long projectOperationId) {
        projectOperationService.deleteProjectOperation(projectOperationId);
    }
}
