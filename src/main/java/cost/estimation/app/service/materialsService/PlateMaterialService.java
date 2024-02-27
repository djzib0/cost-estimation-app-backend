package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.entity.Setting;
import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.repository.AppUserRepository;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import cost.estimation.app.repository.SettingRepository;
import cost.estimation.app.repository.materialsRepository.PlateMaterialRepository;
import cost.estimation.app.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlateMaterialService {

    @Autowired
    private PlateMaterialRepository plateMaterialRepository;

    @Autowired
    private MaterialGradeDicRepository materialGradeDicRepository;

    @Autowired
    private SettingRepository settingRepository;

    public List<PlateMaterial> getAllMaterials() {
        return plateMaterialRepository.findAll();
    }

    public PlateMaterial addPlateMaterial(PlateMaterial newPlateMaterial, Long materialGradeId) {

        Double dimA = newPlateMaterial.getDimensionA() / 1000.0; // mm to meter
        Double dimB = newPlateMaterial.getDimensionB() / 1000.0; // mm to meter
        Double thickness = newPlateMaterial.getThickness();


        // takes density from the material grade dic item,
        // grade passed as a parameter from frontend side
        MaterialGradeDic materialGrade = materialGradeDicRepository.findById(materialGradeId).orElseThrow();
        Double density = materialGrade.getDensity();


        // weight calculation
        newPlateMaterial.setWeight(
                utilities.roundDouble(dimA * dimB * thickness * density, 2)
        );

        // total weight calculation
        newPlateMaterial.setTotalWeight(
                utilities.roundDouble(dimA * dimB * thickness * density * newPlateMaterial.getQuantity(), 2)
        );

        // surface to conserve calculation
        Integer sideToBePainted;
        if (newPlateMaterial.getIsPaintedBothSides()) {
            sideToBePainted = 2;
        } else {
            sideToBePainted = 1;
        }

        newPlateMaterial.setSurfaceToConserve(
                utilities.calculateRectPlateSurface(dimA, dimB, thickness, sideToBePainted)
        );

        // TODO - CREATE UTILITY FUNCTION TO CALCULATE CUTTING TIME
        // TODO - DEPENDING ON IT IS A RING OR RECTANGULAR PLATE ETC.
        // NOW IT'S ONLY FOR TESTS
        newPlateMaterial.setCuttingTime(12.18);

        newPlateMaterial.setTotalValue(
                utilities.roundDouble(newPlateMaterial.getTotalWeight() * newPlateMaterial.getPricePerKg(), 2)
        );

        newPlateMaterial.setMaterialGrade(materialGrade);

        // saving new plateMaterial
        return plateMaterialRepository.save(newPlateMaterial);
    }

    // "importing" utils
    Utilities utilities = new Utilities();
}
