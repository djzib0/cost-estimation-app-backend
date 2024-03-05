package cost.estimation.app.controller;

import cost.estimation.app.entity.MaterialGroup;
import cost.estimation.app.service.MaterialGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialGroupController {

    @Autowired
    private MaterialGroupService materialGroupService;

    @GetMapping("data/materialgroups")
    public List<MaterialGroup> getAllMaterialGroups() {
        return materialGroupService.getAllMaterialGroups();
    }

    @GetMapping("data/materialgroups/{id}")
    public MaterialGroup getMaterialGroupById(@PathVariable("id") Long materialGroupId) {
        return materialGroupService.getMaterialGroupById(materialGroupId);
    }
}
