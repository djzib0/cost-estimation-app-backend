package cost.estimation.app.controller;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.service.MaterialGradeDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialGradeDicController {

    @Autowired
    private MaterialGradeDicService materialGradeDicService;

    @GetMapping("/data/materialgrades")
    public List<MaterialGradeDic> getAllMaterialGradesByGradeGroup(@RequestParam String group) {
        return materialGradeDicService.getAllMaterialGradesByGradeGroup(group);
    }

    @PostMapping("/data/materialgrades/add")
    public MaterialGradeDic addMaterialGradeDic(@RequestBody MaterialGradeDic newMaterialGrade) {
        return materialGradeDicService.addMaterialGradeDic(newMaterialGrade);
    }

    @PutMapping("/data/materialgrades/edit")
    public MaterialGradeDic editMaterialGradeDic(@RequestBody MaterialGradeDic materialGradeDic) {
        return materialGradeDicService.editMaterialGradeDic(materialGradeDic);
    }
}
