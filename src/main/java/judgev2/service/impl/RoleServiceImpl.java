package judgev2.service.impl;

import judgev2.data.entity.RoleEntity;
import judgev2.data.entity.enumeration.RoleName;
import judgev2.data.service.RoleServiceModel;
import judgev2.repository.RoleRepository;
import judgev2.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleName.values())
                    .forEach(r -> roleRepository.save(new RoleEntity(r)));
        }
    }

    @Override
    public RoleServiceModel findByName(RoleName name) {
        return modelMapper.map(roleRepository.findByName(name), RoleServiceModel.class);
    }
}
