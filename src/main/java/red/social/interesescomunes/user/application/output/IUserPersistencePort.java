package red.social.interesescomunes.user.application.output;

import red.social.interesescomunes.user.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserPersistencePort {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void delete(Long id);
}
