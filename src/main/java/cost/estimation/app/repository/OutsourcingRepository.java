package cost.estimation.app.repository;

import cost.estimation.app.entity.Outsourcing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutsourcingRepository extends JpaRepository<Outsourcing, Long> {

    List<Outsourcing> findAllByProjectId(Long projectId);
}
