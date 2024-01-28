package cost.estimation.app.service;

import cost.estimation.app.entity.AppUser;
import cost.estimation.app.entity.Setting;
import cost.estimation.app.repository.AppUserRepository;
import cost.estimation.app.repository.SettingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    public Setting saveSetting(Long userId) {
        Setting newSetting = new Setting();
        AppUser appUser = appUserRepository.findById(userId).orElseThrow();
        newSetting.setAppUser(appUser);
        return settingRepository.save(newSetting);
    }


    public List<Setting> getAllSettings() {
        return settingRepository.findAll();
    }

    public Setting addSetting(Setting newSetting) {
        return settingRepository.save(newSetting);
    }

    public Setting getSettingByAppUserId(Long appUserId) {
        return settingRepository.findByAppUserId(appUserId);
    }
}
