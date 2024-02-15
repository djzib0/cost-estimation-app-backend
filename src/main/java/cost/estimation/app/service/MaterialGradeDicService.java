package cost.estimation.app.service;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialGradeDicService {

    @Autowired
    private MaterialGradeDicRepository materialGradeDicRepository;


    @Cacheable(value = "AllMaterialGrades")
    public List<MaterialGradeDic> getAllMaterialGrades() {
        return materialGradeDicRepository.findAll();
    }

//    @Cacheable(value = "AllMaterialGradesByGradeGroup")
    public List<MaterialGradeDic> getAllMaterialGradesByGradeGroup(String group) {
        return materialGradeDicRepository.findAllByGradeGroup(group);
    }

    public MaterialGradeDic addMaterialGradeDic(MaterialGradeDic newMaterialGrade) {
        return materialGradeDicRepository.save(newMaterialGrade);
    }

    @Transactional
    public MaterialGradeDic editMaterialGradeDic(MaterialGradeDic materialGradeDic) {
        MaterialGradeDic editedMaterialGrade = materialGradeDicRepository.findById(materialGradeDic.getMaterialGradeId()).orElseThrow();
        editedMaterialGrade.setEuSymbol(materialGradeDic.getEuSymbol());
        editedMaterialGrade.setGerSymbol(materialGradeDic.getGerSymbol());
        editedMaterialGrade.setGradeGroup(materialGradeDic.getGradeGroup());
        return editedMaterialGrade;
    }

    public Long countMaterialGrades() {
       return (long) materialGradeDicRepository.findAll()
                                               .size();
    }

    public void deleteMaterialGrade(Long id) {
        materialGradeDicRepository.deleteById(id);
    }
}
