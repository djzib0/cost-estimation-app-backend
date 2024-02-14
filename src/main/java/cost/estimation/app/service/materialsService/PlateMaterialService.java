package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.repository.MaterialGradeDicRepository;
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

    public List<PlateMaterial> getAllMaterials() {
        return plateMaterialRepository.findAll();
    }

    public PlateMaterial addPlateMaterial(PlateMaterial newPlateMaterial, Long materialGradeId) {
        Double dimA = newPlateMaterial.getDimensionA() / 1000.0; // mm to meter
        Double dimB = newPlateMaterial.getDimensionB() / 1000.0; // mm to meter
        Double thickness = newPlateMaterial.getThickness();
        // should be also get density from material grade but for test I set default
        // density
        Double density = 8.0;

        // weight calculation
        newPlateMaterial.setWeight(
                utilities.roundDouble(dimA * dimB * thickness * density, 2)
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

        // grade passed as a parameter from frontend side
        MaterialGradeDic materialGrade = materialGradeDicRepository.findById(materialGradeId).orElseThrow();
        newPlateMaterial.setMaterialGrade(materialGrade);
        return plateMaterialRepository.save(newPlateMaterial);
    }

    // "importing" utils
    Utilities utilities = new Utilities();
}
