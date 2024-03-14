package cost.estimation.app.controller.materialsController;

import cost.estimation.app.entity.materials.RoundbarMaterial;
import cost.estimation.app.service.materialsService.RoundbarMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoundbarMaterialController {

    @Autowired
    private RoundbarMaterialService roundbarMaterialService;

    @GetMapping("data/materials/roundbar")
    public List<RoundbarMaterial> getAllRoundbars() {
        return roundbarMaterialService.getAllRoundbars();
    }

    @GetMapping("data/materials/roundbar/{id}")
    public List<RoundbarMaterial> getRoundbarsByProjectId(@PathVariable(required = true, name = "id") Long projectId) {
        return roundbarMaterialService.getRoundbarsByProjectId(projectId);
    }

    @PostMapping("data/materials/roundbar/add")
    public RoundbarMaterial addRoundbarMaterial(@RequestBody RoundbarMaterial newRoundbarMaterial, @RequestParam Long materialGradeId) {
        return roundbarMaterialService.addRoundbarMaterial(newRoundbarMaterial, materialGradeId);
    }
}
