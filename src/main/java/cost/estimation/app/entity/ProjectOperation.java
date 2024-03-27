package cost.estimation.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_operation")
public class ProjectOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Long projectOperationId;
    @Column(name = "operation_title" )
    private String operationTitle;
    private Integer quantity;
    @Column(name = "total_value")
    private Double totalValue;
    @Column(name = "hour_type_id" )
    private Long operationHourTypeId;
    @Column(name = "hour_type_name" )
    private String operationHourTypeName;
    @Column(name = "price_per_hour")
    private Double operationPricePerHour;
    private String remark;
    @Column(name = "position_in_project")
    private Long positionInProject;
    @Column(name = "project_id")
    private Long projectId;
}
