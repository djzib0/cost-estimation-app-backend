package cost.estimation.app.entity;

import cost.estimation.app.entity.materials.PlateMaterial;
import cost.estimation.app.entity.materials.RoundbarMaterial;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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
    private String title;
    // one record of the Project can only have one type
    @ManyToOne
    @JoinColumn(
            name = "type_id",
            referencedColumnName = "typeId"
    )
    private ProjectType projectType;
    private String drawingNumber;
    private Double totalValue;
    @OneToMany
    @JoinColumn(name = "project_id", referencedColumnName = "projectId")
    private List<ProjectOperation> operations;
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<PlateMaterial> plateMaterials;
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<RoundbarMaterial> roundbarMaterials;
    private Double materialMargin;
    private Double outsourcingMargin;
    private Double salesMargin;
    private Date dateCreated;

}
