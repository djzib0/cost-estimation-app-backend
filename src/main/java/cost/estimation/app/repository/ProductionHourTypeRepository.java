package cost.estimation.app.repository;

import cost.estimation.app.entity.ProductionHourType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionHourTypeRepository extends JpaRepository<ProductionHourType, Long> {


}
