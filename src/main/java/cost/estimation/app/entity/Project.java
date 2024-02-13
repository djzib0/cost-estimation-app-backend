package cost.estimation.app.entity;

import cost.estimation.app.entity.materials.PlateMaterial;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectNumber;
    private String projectClientNumber;
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<PlateMaterial> plateMaterials;

}
