package cost.estimation.app.controller;

import cost.estimation.app.entity.ProductionHourType;
import cost.estimation.app.service.ProductionHourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductionHourTypesController {

    @Autowired
    private ProductionHourTypeService productionHourTypeService;

    @GetMapping("data/hourtypes/all")
    public List<ProductionHourType> getAllProductionHourTypes() {
        return productionHourTypeService.getAllProductionHourTypes();
    }
}
