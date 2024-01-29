package cost.estimation.app.service;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialGradeDicService {

    @Autowired
    private MaterialGradeDicRepository materialGradeDicRepository;


    public List<MaterialGradeDic> getAllMaterialGrades() {
        return materialGradeDicRepository.findAll();
    }
}
