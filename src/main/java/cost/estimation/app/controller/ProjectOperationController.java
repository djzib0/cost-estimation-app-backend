package cost.estimation.app.controller;

import cost.estimation.app.entity.Project;
import cost.estimation.app.entity.ProjectOperation;
import cost.estimation.app.service.ProjectOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectOperationController {

    @Autowired
    private ProjectOperationService projectOperationService;

    @GetMapping("data/operations/all")
    public List<ProjectOperation> getAllProjectOperations() {
        return projectOperationService.getAllProjectOperations();
    }
}
