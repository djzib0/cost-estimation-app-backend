package cost.estimation.app.service;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.repository.MaterialGradeDicRepository;
import cost.estimation.app.utils.Utilities;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MaterialGradeDicService {

    @Autowired
    private MaterialGradeDicRepository materialGradeDicRepository;


//    @Cacheable(value = "AllMaterialGrades")
    public List<MaterialGradeDic> getAllMaterialGrades() {
        return materialGradeDicRepository.findAll();
    }

//    @Cacheable(value = "AllMaterialGradesByGradeGroup")
    public List<MaterialGradeDic> getAllMaterialGradesByGradeGroup(String group) {
        return materialGradeDicRepository.findAllByGradeGroup(group);
    }

//    @CacheEvict(value = "AllMaterialGradesByGradeGroup", allEntries = true)
    public MaterialGradeDic addMaterialGradeDic(MaterialGradeDic newMaterialGrade) {
        return materialGradeDicRepository.save(newMaterialGrade);
    }

    @Transactional
//    @CacheEvict(value = "AllMaterialGradesByGradeGroup", allEntries = true)
    public MaterialGradeDic editMaterialGradeDic(MaterialGradeDic materialGradeDic) {
        System.out.println(materialGradeDic.getDensity());
        Double density = materialGradeDic.getDensity();
        MaterialGradeDic editedMaterialGrade = materialGradeDicRepository.findById(materialGradeDic.getMaterialGradeId()).orElseThrow();
        editedMaterialGrade.setEuSymbol(materialGradeDic.getEuSymbol());
        editedMaterialGrade.setGerSymbol(materialGradeDic.getGerSymbol());
        editedMaterialGrade.setDensity(materialGradeDic.getDensity());
        System.out.println(editedMaterialGrade.getDensity() + " value in edited entry");
        editedMaterialGrade.setGradeGroup(materialGradeDic.getGradeGroup());
        return editedMaterialGrade;
    }

    public Long countMaterialGrades() {
       return (long) materialGradeDicRepository.findAll()
                                               .size();
    }

//    @CacheEvict(value = "AllMaterialGradesByGradeGroup", allEntries = true)
    public void deleteMaterialGrade(Long id) {
        materialGradeDicRepository.deleteById(id);
    }

    Utilities utilities = new Utilities();
}
