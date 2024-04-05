package cost.estimation.app.controller;

import cost.estimation.app.entity.Unit;
import cost.estimation.app.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("data/units")
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @PostMapping("data/units/add")
    public Unit newUnit(@RequestBody Unit newUnit) {
        return unitService.addNewUnit(newUnit);
    }

    @PutMapping("data/units/edit")
    public Unit editUnit(@RequestBody Unit editedUnit) {
        return unitService.editUnit(editedUnit);
    }

    @DeleteMapping("data/units/delete/{id}")
    public void deleteUnit(@PathVariable("id") Long unitId) {
        unitService.deleteUnit(unitId);
    }
}
