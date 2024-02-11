package cost.estimation.app.repository;

import cost.estimation.app.entity.MaterialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialGroupRepository extends JpaRepository<MaterialGroup, Long> {
}
