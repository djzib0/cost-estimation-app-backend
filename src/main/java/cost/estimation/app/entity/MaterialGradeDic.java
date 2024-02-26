package cost.estimation.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialGradeDic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialGradeId;
    private String euSymbol;
    private String gerSymbol;
    private Double density;
    private String gradeGroup;
}
