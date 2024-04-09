package cost.estimation.app.controller;

import cost.estimation.app.entity.Outsourcing;
import cost.estimation.app.service.OutsourcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutsourcingController {

    @Autowired
    private OutsourcingService outsourcingService;

    @GetMapping("data/project/{projectId}/outsourcing/all")
    public List<Outsourcing> getAllOutsourcingByProjectId(@PathVariable Long projectId){
        return outsourcingService.getAllOutsourcingByProjectId(projectId);
    }

    @GetMapping("data/outsourcing/all")
    public List<Outsourcing> getAllOutsourcing() {
        return outsourcingService.getAllOutsourcing();
    }

    @PostMapping("data/outsourcing/add")
    public Outsourcing addOutsourcing(@RequestBody Outsourcing newOutsourcing) {
        return outsourcingService.addOutsourcing(newOutsourcing);
    }

    @PutMapping("data/outsourcing/edit")
    public Outsourcing editOutsourcing(@RequestBody Outsourcing editedOutsourcing) {
        return outsourcingService.editOutsourcing(editedOutsourcing);
    }

    @DeleteMapping("data/outsourcing/delete/{id}")
    public void deleteOutsourcing(@PathVariable("id") Long outsourcingId) {
        outsourcingService.deleteOutsourcing(outsourcingId);
    }
}
