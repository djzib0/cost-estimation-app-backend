package cost.estimation.app.service;

import cost.estimation.app.entity.MaterialGradeDic;
import cost.estimation.app.error.MaterialGradeDicAlreadyExistException;
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
    public MaterialGradeDic addMaterialGradeDic(MaterialGradeDic newMaterialGradeDic) throws MaterialGradeDicAlreadyExistException {

        MaterialGradeDic materialGradeDic = materialGradeDicRepository.findByEuSymbol(newMaterialGradeDic.getEuSymbol());
        System.out.println(materialGradeDicRepository.existsByEuSymbol(newMaterialGradeDic.getEuSymbol()));
        if (materialGradeDicRepository.existsByEuSymbol(newMaterialGradeDic.getEuSymbol())) {
            throw new MaterialGradeDicAlreadyExistException("This EU symbol already exists. Please use a different name");
        }

        if (materialGradeDicRepository.existsByGerSymbol(newMaterialGradeDic.getGerSymbol())) {
            throw new MaterialGradeDicAlreadyExistException("This German symbol already exists. Please use a different name");
        }

        return materialGradeDicRepository.save(newMaterialGradeDic);
    }

    @Transactional
//    @CacheEvict(value = "AllMaterialGradesByGradeGroup", allEntries = true)
    public MaterialGradeDic editMaterialGradeDic(MaterialGradeDic newMaterialGradeDic) throws MaterialGradeDicAlreadyExistException {

        Double density = newMaterialGradeDic.getDensity();
        MaterialGradeDic editedMaterialGrade = materialGradeDicRepository.findById(newMaterialGradeDic.getMaterialGradeId()).orElseThrow();

        MaterialGradeDic materialGradeDic = materialGradeDicRepository.findByEuSymbol(newMaterialGradeDic.getEuSymbol());

        // if the new value is the same as previous value, it means there is no change,
        // and we can omit the UNIQUE constraint and save the entry after edit
        if (materialGradeDicRepository.existsByEuSymbol(newMaterialGradeDic.getEuSymbol())
        && !editedMaterialGrade.getEuSymbol().equals(newMaterialGradeDic.getEuSymbol())) {
            throw new MaterialGradeDicAlreadyExistException("This EU symbol already exists. Please use a different name");
        }

        // if the new value is the same as previous value, it means there is no change,
        // and we can omit the UNIQUE constraint and save the entry after edit
        if (materialGradeDicRepository.existsByGerSymbol(newMaterialGradeDic.getGerSymbol())
        && !editedMaterialGrade.getGerSymbol().equals(newMaterialGradeDic.getGerSymbol())) {
            throw new MaterialGradeDicAlreadyExistException("This German symbol already exists. Please use a different name");
        }

        editedMaterialGrade.setEuSymbol(newMaterialGradeDic.getEuSymbol());
        editedMaterialGrade.setGerSymbol(newMaterialGradeDic.getGerSymbol());
        editedMaterialGrade.setDensity(newMaterialGradeDic.getDensity());
        editedMaterialGrade.setGradeGroup(newMaterialGradeDic.getGradeGroup());

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
