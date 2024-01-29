package cost.estimation.app.controller;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.entity.Setting;
import cost.estimation.app.service.AppUserService;
import cost.estimation.app.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SettingController {

    @Autowired
    private SettingService settingService;

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/test/{id}")
    public Setting setting(@PathVariable Long id){
        return settingService.saveSetting(id);
    }

    @GetMapping("data/settings")
    public List<Setting> getAllSettings() {
        return settingService.getAllSettings();
    }

    @GetMapping("data/settings/user/{id}")
    public Setting getSettingByAppUserId(@PathVariable("id") Long appUserId) {
        return settingService.getSettingByAppUserId(appUserId);
    }

    @PostMapping("data/settings/add")
    public Setting addSetting(@RequestBody Setting setting) {
        return settingService.addSetting(setting);
    }

    @PutMapping("data/settings/{id}")
    public Setting updateSetting(@RequestBody Setting setting) {
        return settingService.updateSetting(setting);
    }


}
