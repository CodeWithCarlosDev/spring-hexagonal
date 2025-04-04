package red.social.interesescomunes.role.application.input;

import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {
    List<Role> findAllRoles();
    Role findRoleById(Long id);
    Role findRoleByType(String name); // Nuevo método
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRoleById(Long id);
}
