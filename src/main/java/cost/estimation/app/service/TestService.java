package cost.estimation.app.service;

import cost.estimation.app.entity.TestEntity;
import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.repository.materialsRepository.PlateMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private PlateMaterialRepository plateMaterialRepository;

    public TestEntity getResult() {
        TestEntity testEntity = new TestEntity();
        testEntity.setValueA(Long.valueOf(2));
        testEntity.setValueB(Long.valueOf(2));
        return testEntity;
    }
}
