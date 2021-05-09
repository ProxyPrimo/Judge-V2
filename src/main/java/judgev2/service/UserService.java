package judgev2.service;

import judgev2.data.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    UserServiceModel findByUsernameAndPassword(UserServiceModel userServiceModel);
}
