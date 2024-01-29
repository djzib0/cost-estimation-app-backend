package cost.estimation.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialGradeDic {

    @Id
    private Long materialGradeId;
    private String euSymbol;
    private String gerSymbol;
}
