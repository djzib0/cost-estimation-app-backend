package cost.estimation.app.controller;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.service.MaterialGradeDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialGradeDicController {

    @Autowired
    private MaterialGradeDicService materialGradeDicService;

    @GetMapping("/data/materialgrades")
    public List<MaterialGradeDic> getAllMaterialGrades() {
        return materialGradeDicService.getAllMaterialGrades();
    }
}
