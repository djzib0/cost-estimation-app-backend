package cost.estimation.app.entity.materials;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otherMaterialId;
    @Column(name = "name")
    private String otherMaterialName;
    private Integer quantity;
    @Column(name = "unit_name")
    private String unitName;
    @Column(name = "price_per_unit")
    private Double pricePerUnit;
    @Column(name = "total_value")
    private Double totalValue;
    private String remark;
    @Column(name = "project_id")
    private Long projectId;


}
