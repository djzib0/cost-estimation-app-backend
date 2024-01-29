package cost.estimation.app.repository;

import cost.estimation.app.entity.MaterialGradeDic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialGradeDicRepository extends JpaRepository<MaterialGradeDic, Long> {

}
