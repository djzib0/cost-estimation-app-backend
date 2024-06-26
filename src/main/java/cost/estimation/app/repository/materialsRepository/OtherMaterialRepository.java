package cost.estimation.app.repository.materialsRepository;

import cost.estimation.app.entity.materials.OtherMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherMaterialRepository extends JpaRepository<OtherMaterial, Long> {
    List<OtherMaterial> findAllByProjectId(Long projectId);
}
