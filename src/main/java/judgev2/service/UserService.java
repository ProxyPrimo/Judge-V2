package judgev2.service;

import judgev2.data.entity.UserEntity;
import judgev2.data.entity.enumeration.RoleName;
import judgev2.data.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    void login(UserServiceModel userServiceModel);
    UserServiceModel findByUsernameAndPassword(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleName valueOf);

    UserEntity findById(String id);
}
