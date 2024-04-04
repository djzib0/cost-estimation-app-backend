package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.materials.OtherMaterial;
import cost.estimation.app.repository.materialsRepository.OtherMaterialRepository;
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
}
