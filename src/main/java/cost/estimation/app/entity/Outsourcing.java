package cost.estimation.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Outsourcing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outsourcing_id")
    private Long outsourcingId;
    @Column(name = "outsourcing_name")
    private String outsourcingName;
    @Column(name = "contractor_name")
    private String contractorName;
    @Column(name = "outsourcing_value")
    private Double outsourcingValue;
    private String remark;
    @Column(name = "project_id")
    private Long projectId;
}
