package cost.estimation.app.repository.materialsRepository;

import cost.estimation.app.entity.materials.RoundbarMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundbarMaterialRepository extends JpaRepository<RoundbarMaterial, Long> {
}
