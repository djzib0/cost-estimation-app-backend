package cost.estimation.app.controller.materialsController;

import cost.estimation.app.entity.materials.OtherMaterial;
import cost.estimation.app.service.materialsService.OtherMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OtherMaterialController {

    @Autowired
    private OtherMaterialService otherMaterialService;

    @GetMapping("data/materials/othermaterials")
    public List<OtherMaterial> getAllMaterials() {
        return otherMaterialService.getAllOtherMaterials();
    }
}
