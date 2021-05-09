package judgev2.service;

import judgev2.data.entity.enumeration.RoleName;
import judgev2.data.service.RoleServiceModel;

public interface RoleService {
    void initRoles();
    RoleServiceModel findByName(RoleName name);
}
