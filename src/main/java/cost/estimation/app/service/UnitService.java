package cost.estimation.app.service;

import cost.estimation.app.entity.Unit;
import cost.estimation.app.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit addNewUnit(Unit newUnit) {
        return unitRepository.save(newUnit);
    }

    @Transactional
    public Unit editUnit(Unit editedUnit) {
        Unit newUnit = unitRepository.findById(editedUnit.getUnitId()).orElseThrow();

        newUnit.setUnitName(editedUnit.getUnitName());
        newUnit.setUnitNameAbbreviation((editedUnit.getUnitNameAbbreviation()));

        return newUnit;
    }

    public void deleteUnit(Long unitId) {
        unitRepository.deleteById(unitId);
    }
}
