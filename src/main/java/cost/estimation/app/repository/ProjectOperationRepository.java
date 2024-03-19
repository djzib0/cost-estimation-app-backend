package cost.estimation.app.repository;

import cost.estimation.app.entity.ProjectOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectOperationRepository extends JpaRepository<ProjectOperation, Long> {

    List<ProjectOperation> findAllByProjectId(Long projectId);
}
