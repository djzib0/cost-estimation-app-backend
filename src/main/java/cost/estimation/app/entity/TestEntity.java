package cost.estimation.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {

    @Id
    private Long testId;
    private Long valueA;
    private Long valueB;
    private Long result;
}
