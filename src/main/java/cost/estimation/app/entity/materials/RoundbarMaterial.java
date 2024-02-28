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
public class RoundbarMaterial {

    // TODO - add value and totalValue

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roundbarMaterialId;
    private Integer diameter;
    private Double profileLength;
    private Double weight;
    @Column(name = "weight_per_meter")
    private Double weightPerMeter; // calculated from given diameter and grade
    private Integer quantity;
    @Column(name = "is_painted")
    private Boolean isPainted;
    @Column(name = "surface_to_conserve")
    private Double surfaceToConserve;
    private Double cuttingTime; // time in minutes, to be converted to hours and minutes|
    @Column(name = "project_id")
    private Long projectId;
    @Column(name = "price_per_kg")
    private Double pricePerKg;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "material_grade_id",
            referencedColumnName = "materialGradeId"
    )
    private MaterialGradeDic materialGrade;
}
