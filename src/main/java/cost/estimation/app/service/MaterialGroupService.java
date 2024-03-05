package cost.estimation.app.service;

import cost.estimation.app.entity.MaterialGroup;
import cost.estimation.app.repository.MaterialGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialGroupService {

    @Autowired
    private MaterialGroupRepository materialGroupRepository;

    public List<MaterialGroup> getAllMaterialGroups() {
        return materialGroupRepository.findAll();
    }

    public MaterialGroup getMaterialGroupById(Long materialGroupId) {
        return materialGroupRepository.findById(materialGroupId).orElseThrow();
    }
}
