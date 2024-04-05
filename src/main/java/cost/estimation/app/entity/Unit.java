package cost.estimation.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;
    @Column(name = "unit_name")
    private String unitName;
    @Column(name = "unit_name_abbreviation")
    private String unitNameAbbreviation;
}
