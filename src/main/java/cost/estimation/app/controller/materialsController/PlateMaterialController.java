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

    @PostMapping("data/materials/platematerial/add")
    public PlateMaterial addPlateMaterial(@RequestBody PlateMaterial newPlateMaterial, @RequestParam Long materialGradeId) {
        return plateMaterialService.addPlateMaterial(newPlateMaterial, materialGradeId);
    }

}
