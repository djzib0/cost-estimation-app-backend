package cost.estimation.app.controller.materialsController;

import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.service.materialsService.PlateMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlateMaterialController {

    @Autowired
    private PlateMaterialService plateMaterialService;

    @GetMapping("data/materials/platematerial")
    public List<PlateMaterial> getAllMaterials() {
        return plateMaterialService.getAllMaterials();
    }

    @GetMapping("data/project/{projectId}/materials/platematerial")
    public List<PlateMaterial> getAllPlateMaterialsByProjectId(@PathVariable(required = false, name = "projectId") Long projectId) {
        return plateMaterialService.getAllPlateMaterialsByProjectId(projectId);
    }

    @PostMapping("data/materials/platematerial/add")
    public PlateMaterial addPlateMaterial(@RequestBody PlateMaterial newPlateMaterial,
                                          @RequestParam(required = true) Long materialGradeId) {
        return plateMaterialService.addPlateMaterial(newPlateMaterial, materialGradeId);
    }

    @PutMapping("data/materials/platematerial/edit")
    public PlateMaterial editPlateMaterial(
            @RequestBody PlateMaterial plateMaterial,
            @RequestParam(required = true) Long materialGradeId) {
        return plateMaterialService.editPlateMaterial(plateMaterial, materialGradeId);
    }

    @DeleteMapping("data/materials/platematerial/delete/{id}")
    public void deletePlateMaterial(@PathVariable("id") Long plateMaterialId) {
        plateMaterialService.deletePlateMaterial(plateMaterialId);
    }

}
