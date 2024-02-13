package cost.estimation.app.entity.materials;

import cost.estimation.app.entity.MaterialGradeDic;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plateMaterialId;
    private Double dimensionA;
    private Double dimensionB;
    private Double thickness;
    private Double weight;
    private Boolean isPainted;
    private Boolean isPaintedBothSides;
    @Column(name = "project_id")
    private Long projectId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "material_grade",
            referencedColumnName = "materialGradeId"
    )
    private MaterialGradeDic materialGrade;
}
