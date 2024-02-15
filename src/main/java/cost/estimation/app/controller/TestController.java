package cost.estimation.app.controller;

import cost.estimation.app.entity.TestEntity;
import cost.estimation.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("data/test")
    public TestEntity getTestEntity() {
        return testService.getResult();
    }
}
