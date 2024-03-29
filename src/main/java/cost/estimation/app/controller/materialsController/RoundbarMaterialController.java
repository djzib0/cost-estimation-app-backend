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

    @GetMapping("data/project/{projectId}/materials/roundbar")
    public List<RoundbarMaterial> getRoundbarsByProjectId(@PathVariable(required = true, name = "projectId") Long projectId) {
        return roundbarMaterialService.getRoundbarsByProjectId(projectId);
    }

    @PostMapping("data/materials/roundbar/add")
    public RoundbarMaterial addRoundbarMaterial(@RequestBody RoundbarMaterial newRoundbarMaterial, @RequestParam Long materialGradeId) {
        return roundbarMaterialService.addRoundbarMaterial(newRoundbarMaterial, materialGradeId);
    }

    @PutMapping("data/materials/roundbar/edit")
    public RoundbarMaterial editRoundbarMaterial(
            @RequestBody RoundbarMaterial roundbarMaterial,
            @RequestParam(required = true) Long materialGradeId
    ) {
        return roundbarMaterialService.editRoundbarMaterial(roundbarMaterial, materialGradeId);
    };

    @DeleteMapping("data/materials/roundbarmaterial/delete/{id}")
    public void deleteRoundbarMaterial(@PathVariable("id") Long roundbarMaterialId) {
        roundbarMaterialService.deleteRoundbarMaterial(roundbarMaterialId);
    }
}
