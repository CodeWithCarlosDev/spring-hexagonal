package red.social.interesescomunes.role.application.output;



import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRolePersistencePort {
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Optional<Role> findByType(TypeRole name);
    Role save(Role role);
    void delete(Long id);
}
