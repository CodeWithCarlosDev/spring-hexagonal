package red.social.interesescomunes.user.application.input;

import red.social.interesescomunes.user.domain.model.User;
import java.util.List;

public interface IUserServicePort {
    List<User> findAllUsers();
    User findUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUserById(Long id);
}
