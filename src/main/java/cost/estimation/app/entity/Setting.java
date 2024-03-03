package cost.estimation.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Setting {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long settingId;
    @Column(name = "app_user_id", insertable = false, updatable = false)
    private Long appUserId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_id", referencedColumnName = "appUserId")
    @JsonIgnore
    @JsonProperty
    private AppUser appUser;
    private String theme;
    @Column(name = "steel_grade_a_default_price_per_kg")
    private Double steelGradeADefaultPricePerKg;
    @Column(name = "steel_grade_s355_default_price_per_kg")
    private Double steelGradeS355DefaultPricePerKg;
    @Column(name = "stainless_steel_default_price_per_kg")
    private Double stainlessSteelDefaultPricePerKg;
    @Column(name = "default_material_margin")
    private Double defaultMaterialMargin;
    @Column(name = "default_outsourcing_margin" )
    private Double defaultOutsourcingMargin;
    @Column(name = "default_sales_margin")
    private Double defaultSalesMargin;
}
