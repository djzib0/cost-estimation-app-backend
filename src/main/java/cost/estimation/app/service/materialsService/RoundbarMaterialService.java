package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.entity.materials.RoundbarMaterial;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import cost.estimation.app.repository.materialsRepository.RoundbarMaterialRepository;
import cost.estimation.app.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundbarMaterialService {

    @Autowired
    private RoundbarMaterialRepository roundbarMaterialRepository;

    @Autowired
    private MaterialGradeDicRepository materialGradeDicRepository;

    public List<RoundbarMaterial> getAllRoundbars() {
        return roundbarMaterialRepository.findAll();
    }

    public RoundbarMaterial addRoundbarMaterial(RoundbarMaterial newRoundbarMaterial, Long materialGradeId) {

        Double diameterInMeters = newRoundbarMaterial.getDiameter() / 1000.0; // mm to meter
        Double profileLengthInMeters = newRoundbarMaterial.getProfileLength() / 1000; // mm to meter
        Double length = newRoundbarMaterial.getProfileLength();


        // takes density from the material grade dic item,
        // grade passed as a parameter from frontend side
        MaterialGradeDic materialGrade = materialGradeDicRepository.findById(materialGradeId).orElseThrow();
        Double density = materialGrade.getDensity();

        newRoundbarMaterial.setWeight(
                utilities.calculateRoundbarWeight(diameterInMeters, length, density)
        );

        newRoundbarMaterial.setWeightPerMeter(
                utilities.calculateRoundbarWeightPerMeter(diameterInMeters, density)
        );

        // calculate and set surface to conserve
        // if it's not painted, set surface to zero
        Double surfaceToConserve;
        if (newRoundbarMaterial.getIsPainted()) {
             surfaceToConserve = utilities.calculateSurfaceByDiameterAndLength(diameterInMeters, profileLengthInMeters);
        } else {
            surfaceToConserve = 0.0;
        }

        // TODO - this is a cutting time for test,
        // create a function to calculate a cutting time based on
        // the give diameter
        newRoundbarMaterial.setCuttingTime(13.0); // 13 minutes

        newRoundbarMaterial.setSurfaceToConserve(surfaceToConserve);

        newRoundbarMaterial.setTotalValue(
                newRoundbarMaterial.getWeight() * newRoundbarMaterial.getPricePerKg() * newRoundbarMaterial.getQuantity()
        );

        newRoundbarMaterial.setMaterialGrade(materialGrade.getEuSymbol());

        newRoundbarMaterial.setDensity(materialGrade.getDensity());

        return roundbarMaterialRepository.save(newRoundbarMaterial);
    }

    Utilities utilities = new Utilities();
}
