package judgev2.data.service;

import judgev2.data.entity.enumeration.RoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleServiceModel extends BaseServiceModel {
    private RoleName name;
}
