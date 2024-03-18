package cost.estimation.app.service;

import cost.estimation.app.entity.ProductionHourType;
import cost.estimation.app.repository.ProductionHourTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionHourTypeService {

    @Autowired
    private ProductionHourTypeRepository productionHourTypeRepository;

    public List<ProductionHourType> getAllProductionHourTypes() {
        return productionHourTypeRepository.findAll();
    }
}
