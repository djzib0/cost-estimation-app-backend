package cost.estimation.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hour_type")
public class ProductionHourType {

    @Id
    @Column(name = "type_id")
    private Long productionHourTypeId;
    @Column(name = "type_name")
    private String productionHourTypeName;
    @Column(name = "default_price_per_hour")
    private Double productionHourTypePricePerHour;

}
