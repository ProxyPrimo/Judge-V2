package judgev2.data.entities;

import judgev2.data.entities.enumeration.RoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity extends BaseEntity {
    @Enumerated
    private RoleName name;
}
