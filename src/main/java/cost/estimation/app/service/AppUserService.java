package cost.estimation.app.service;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.entity.Setting;
import cost.estimation.app.entity.Theme;
import cost.estimation.app.repository.AppUserRepository;
import cost.estimation.app.repository.SettingRepository;
import cost.estimation.app.repository.ThemeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private SettingService settingService;

    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }


    public AppUser addNewUser(AppUser newAppUser) {
        Setting setting = new Setting();
        Theme theme = themeRepository.findById((long) 1).orElseThrow();
        setting.setTheme(theme);
        setting.setAppUser(newAppUser);
        newAppUser.setSetting(setting);
        settingService.addSetting(setting);
        appUserRepository.save(newAppUser);
        return newAppUser;
    }

    public AppUser getAppUser(Long appUserId) {
        return appUserRepository.findById(appUserId).orElseThrow();
    }
}
