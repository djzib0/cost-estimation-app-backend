package cost.estimation.app.repository.materialsRepository;

import cost.estimation.app.entity.materials.PlateMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateMaterialRepository extends JpaRepository<PlateMaterial, Long> {
    List<PlateMaterial> findAllByProjectId(Long projectId);
}
