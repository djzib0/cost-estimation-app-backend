package cost.estimation.app.repository;

import cost.estimation.app.entity.MaterialGradeDic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialGradeDicRepository extends JpaRepository<MaterialGradeDic, Long> {

//    @Query("select m from MaterialGrade where gradeGroup = :group")
    List<MaterialGradeDic> findAllByGradeGroup(String group);


}
