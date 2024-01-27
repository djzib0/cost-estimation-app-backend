package cost.estimation.app.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Theme {

    @Id
    private Long themeId;
    private String name;
}
