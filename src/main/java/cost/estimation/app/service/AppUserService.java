package cost.estimation.app.service;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.entity.Setting;
import cost.estimation.app.repository.AppUserRepository;
import cost.estimation.app.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private SettingService settingService;

    @Cacheable(value = "AllAppUsers")
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }


    public AppUser addNewUser(AppUser newAppUser) {
        Setting setting = new Setting();
        setting.setAppUser(newAppUser);
        newAppUser.setSetting(setting);
        settingService.addSetting(setting);
        appUserRepository.save(newAppUser);
        return newAppUser;
    }

    @Cacheable(value = "AppUser")
    public AppUser getAppUser(Long appUserId) {
        return appUserRepository.findById(appUserId).orElseThrow();
    }
}
