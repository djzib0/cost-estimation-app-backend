package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.entity.materials.RoundbarMaterial;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import cost.estimation.app.repository.materialsRepository.RoundbarMaterialRepository;
import cost.estimation.app.utils.Utilities;
import jakarta.transaction.Transactional;
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

        newRoundbarMaterial.setSurfaceToConserve(surfaceToConserve);

        // TODO - this is a cutting time for test,
        // create a function to calculate a cutting time based on
        // the give diameter
        newRoundbarMaterial.setCuttingTime(13.0); // 13 minutes

        newRoundbarMaterial.setTotalValue(
                newRoundbarMaterial.getWeight() * newRoundbarMaterial.getPricePerKg() * newRoundbarMaterial.getQuantity()
        );

        newRoundbarMaterial.setTotalWeight(
                newRoundbarMaterial.getWeight() * newRoundbarMaterial.getQuantity()
        );


        newRoundbarMaterial.setMaterialGrade(materialGrade.getEuSymbol());

        newRoundbarMaterial.setDensity(materialGrade.getDensity());

        return roundbarMaterialRepository.save(newRoundbarMaterial);
    }

    Utilities utilities = new Utilities();

    public List<RoundbarMaterial> getRoundbarsByProjectId(Long projectId) {
        return roundbarMaterialRepository.findAllByProjectId(projectId);
    }

    @Transactional
    public RoundbarMaterial editRoundbarMaterial(RoundbarMaterial roundbarMaterial, Long materialGradeId) {
        RoundbarMaterial editedRoundbarMaterial = roundbarMaterialRepository.findById(roundbarMaterial.getRoundbarMaterialId()).orElseThrow();

        Double diameterInMeters = roundbarMaterial.getDiameter() / 1000.0; // mm to meter
        Double profileLengthInMeters = roundbarMaterial.getProfileLength() / 1000; // mm to meter
        Double length = roundbarMaterial.getProfileLength();
        // takes density from the material grade dic item,
        // grade passed as a parameter from frontend side
        MaterialGradeDic materialGrade = materialGradeDicRepository.findById(materialGradeId).orElseThrow();
        Double density = materialGrade.getDensity();
        Double weight = utilities.calculateRoundbarWeight(diameterInMeters, length, density);

        editedRoundbarMaterial.setProjectId(roundbarMaterial.getProjectId());

        editedRoundbarMaterial.setDiameter(roundbarMaterial.getDiameter());

        editedRoundbarMaterial.setProfileLength(roundbarMaterial.getProfileLength());

        editedRoundbarMaterial.setWeight(weight);

        editedRoundbarMaterial.setWeightPerMeter(
                utilities.calculateRoundbarWeightPerMeter(diameterInMeters, density)
        );

        editedRoundbarMaterial.setQuantity(roundbarMaterial.getQuantity());

        editedRoundbarMaterial.setTotalWeight(
                weight * editedRoundbarMaterial.getQuantity()
        );

        editedRoundbarMaterial.setIsPainted(roundbarMaterial.getIsPainted());

        // calculate and set surface to conserve
        // if it's not painted, set surface to zero
        Double surfaceToConserve;
        if (roundbarMaterial.getIsPainted()) {
            surfaceToConserve = utilities.calculateSurfaceByDiameterAndLength(diameterInMeters, profileLengthInMeters);
        } else {
            surfaceToConserve = 0.0;
        }

        editedRoundbarMaterial.setSurfaceToConserve(surfaceToConserve);

        // TODO - this is a cutting time for test,
        // create a function to calculate a cutting time based on
        // the give diameter
        editedRoundbarMaterial.setCuttingTime(roundbarMaterial.getCuttingTime());

        editedRoundbarMaterial.setProjectId(roundbarMaterial.getProjectId());

        editedRoundbarMaterial.setPricePerKg(roundbarMaterial.getPricePerKg());

        editedRoundbarMaterial.setTotalValue(
                editedRoundbarMaterial.getWeight() * roundbarMaterial.getPricePerKg() * roundbarMaterial.getQuantity()
        );

        editedRoundbarMaterial.setTotalValue(
                editedRoundbarMaterial.getWeight() * roundbarMaterial.getPricePerKg() * roundbarMaterial.getQuantity()
        );

        editedRoundbarMaterial.setRemark(roundbarMaterial.getRemark());

        editedRoundbarMaterial.setMaterialGrade(materialGrade.getEuSymbol());

        editedRoundbarMaterial.setDensity(materialGrade.getDensity());

        return editedRoundbarMaterial;
    }

    public void deleteRoundbarMaterial(Long roundbarMaterialId) {
        roundbarMaterialRepository.deleteById(roundbarMaterialId);
    }
}