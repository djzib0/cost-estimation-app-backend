package cost.estimation.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialGroupId;
    private String groupName;
}
