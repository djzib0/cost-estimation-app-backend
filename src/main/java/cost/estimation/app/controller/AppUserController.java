package cost.estimation.app.controller;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/data/users")
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @GetMapping("/data/users/{id}")
    public AppUser getAppUser(@PathVariable("id") Long appUserId) {
        return appUserService.getAppUser(appUserId);
    }

    @PostMapping("data/users/add")
    public AppUser addAppUser(@RequestBody AppUser newAppUser){
        return appUserService.addNewUser(newAppUser);
    }
}
