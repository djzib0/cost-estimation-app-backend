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
    @Column(name = "dimension_A")
    private Double dimensionA;
    @Column(name = "dimension_B")
    private Double dimensionB;
    private Double thickness;
    private Double weight;
    @Column(name = "is_painted")
    private Boolean isPainted;
    @Column(name = "is_painted_both_sides")
    private Boolean isPaintedBothSides;
    @Column(name = "surface_to_conserve")
    private Double surfaceToConserve;
    @Column(name = "project_id")
    private Long projectId;
    // one entity of the material in calculation can only have one material grade
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "material_grade_id",
            referencedColumnName = "materialGradeId"
    )
    private MaterialGradeDic materialGrade;
}
