package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.materials.OtherMaterial;
import cost.estimation.app.repository.materialsRepository.OtherMaterialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherMaterialService {

    @Autowired
    private OtherMaterialRepository otherMaterialRepository;

    public List<OtherMaterial> getAllOtherMaterials() {
        return otherMaterialRepository.findAll();
    }

    public List<OtherMaterial> getOtherMaterialsByProjectId(Long projectId) {
        return otherMaterialRepository.findAllByProjectId(projectId);
    }

    public OtherMaterial addNewOtherMaterial(OtherMaterial newOtherMaterial) {
        Integer quantity = newOtherMaterial.getQuantity();
        Double pricePerUnit = newOtherMaterial.getPricePerUnit();
        Double totalValue = Double.valueOf(quantity) * pricePerUnit;
        newOtherMaterial.setTotalValue(totalValue);
        return otherMaterialRepository.save(newOtherMaterial);
    }

    @Transactional
    public OtherMaterial editOtherMaterial(OtherMaterial editedOtherMaterial) {
        OtherMaterial newOtherMaterial = otherMaterialRepository.findById(editedOtherMaterial.getOtherMaterialId()).orElseThrow();

        newOtherMaterial.setOtherMaterialName((editedOtherMaterial.getOtherMaterialName()));
        newOtherMaterial.setQuantity(editedOtherMaterial.getQuantity());
        newOtherMaterial.setUnitName(editedOtherMaterial.getUnitName());
        newOtherMaterial.setPricePerUnit(editedOtherMaterial.getPricePerUnit());

        Integer quantity = editedOtherMaterial.getQuantity();
        Double pricePerUnit = editedOtherMaterial.getPricePerUnit();
        Double totalValue = Double.valueOf(quantity) * pricePerUnit;
        newOtherMaterial.setTotalValue(totalValue);

        newOtherMaterial.setRemark(editedOtherMaterial.getRemark());
        newOtherMaterial.setProjectId(editedOtherMaterial.getProjectId());

        return newOtherMaterial;
    }

    public void deleteOtherMaterial(Long otherMaterialId) {
        otherMaterialRepository.deleteById(otherMaterialId);
    }
}
