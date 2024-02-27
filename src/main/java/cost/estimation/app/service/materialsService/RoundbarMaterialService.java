package cost.estimation.app.service.materialsService;

import cost.estimation.app.entity.materials.RoundbarMaterial;
import cost.estimation.app.repository.materialsRepository.RoundbarMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundbarMaterialService {

    @Autowired
    private RoundbarMaterialRepository roundbarMaterialRepository;

    public List<RoundbarMaterial> getAllRoundbars() {
        return roundbarMaterialRepository.findAll();
    }
}
