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
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
}
