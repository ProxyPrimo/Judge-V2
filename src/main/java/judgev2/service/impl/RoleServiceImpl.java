package judgev2.service.impl;

import judgev2.data.entities.RoleEntity;
import judgev2.data.entities.enumeration.RoleName;
import judgev2.repository.RoleRepository;
import judgev2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleName.values())
                    .forEach(r -> roleRepository.save(new RoleEntity(r)));
        }
    }
}
