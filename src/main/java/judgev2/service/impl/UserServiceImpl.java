package judgev2.service.impl;

import judgev2.data.entity.UserEntity;
import judgev2.data.entity.enumeration.RoleName;
import judgev2.data.service.UserServiceModel;
import judgev2.repository.UserRepository;
import judgev2.security.CurrentUser;
import judgev2.service.RoleService;
import judgev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(RoleService roleService, UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        userServiceModel.setRole(roleService
                .findByName(userRepository.count() == 0 ? RoleName.ADMIN : RoleName.USER));

        UserEntity userEntity = modelMapper
                .map(userServiceModel, UserEntity.class);

        userRepository.save(userEntity);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(UserServiceModel userServiceModel) {
        UserEntity userEntity = userRepository
                .findByUsernameAndPassword(userServiceModel.getUsername()
                        , userServiceModel.getPassword());

        return userEntity == null ? null : modelMapper.map(userEntity, UserServiceModel.class);
    }
}
