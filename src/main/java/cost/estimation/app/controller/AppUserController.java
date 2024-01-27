package cost.estimation.app.controller;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/data/users")
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @PostMapping("data/users/add")
    public AppUser addAppUser(@RequestBody AppUser newAppUser){
        return appUserService.addNewUser(newAppUser);
    }
}
