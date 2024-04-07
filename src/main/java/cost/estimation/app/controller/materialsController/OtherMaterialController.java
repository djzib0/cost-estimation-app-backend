package cost.estimation.app.controller.materialsController;

import cost.estimation.app.entity.materials.OtherMaterial;
import cost.estimation.app.service.materialsService.OtherMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OtherMaterialController {

    @Autowired
    private OtherMaterialService otherMaterialService;

    @GetMapping("data/materials/othermaterials")
    public List<OtherMaterial> getAllMaterials() {
        return otherMaterialService.getAllOtherMaterials();
    }

    @GetMapping("data/project/{projectId}/materials/other")
    public List<OtherMaterial> getOtherMaterialsByProjectId(@PathVariable(name = "projectId") Long projectId) {
        return otherMaterialService.getOtherMaterialsByProjectId(projectId);
    }

    @PostMapping("data/materials/othermaterials/add")
    public OtherMaterial addNewOtherMaterial(
            @RequestBody OtherMaterial newOtherMaterial) {
        return otherMaterialService.addNewOtherMaterial(newOtherMaterial);
    }

    @PutMapping("data/materials/othermaterials/edit")
    public OtherMaterial editOtherMaterial(
            @RequestBody OtherMaterial editedOtherMaterial) {
        return otherMaterialService.editOtherMaterial(editedOtherMaterial);
    }

    @DeleteMapping("data/materials/othermaterials/delete/{id}")
    public void deleteOtherMaterial(@PathVariable("id") Long otherMaterialId) {
        otherMaterialService.deleteOtherMaterial(otherMaterialId);
    }
}
