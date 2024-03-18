package cost.estimation.app.repository;

import cost.estimation.app.entity.ProjectOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectOperationRepository extends JpaRepository<ProjectOperation, Long> {
}
