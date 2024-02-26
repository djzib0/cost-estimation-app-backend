package cost.estimation.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    private String typeName;
}
