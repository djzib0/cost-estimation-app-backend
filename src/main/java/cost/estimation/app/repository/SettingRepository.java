package cost.estimation.app.repository;

import cost.estimation.app.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

    @Query
    Setting findByAppUserId(Long appUserId);
}
