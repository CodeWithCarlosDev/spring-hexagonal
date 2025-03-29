package red.social.interesescomunes.role.application.service;

import org.springframework.stereotype.Service;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.role.application.output.IRolePersistencePort;
import red.social.interesescomunes.role.domain.exception.RoleNotFoundException;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleServicePort {

    private final IRolePersistencePort repositoy;

    public RoleServiceImpl(IRolePersistencePort repositoy) {
        this.repositoy = repositoy;
    }

    @Override
    public List<Role> findAllRoles() {
        return repositoy.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
        return repositoy.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));
    }

    @Override
    public Role createRole(Role role) {
        System.out.println("createRole : service ");
        return repositoy.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
       Role saveRole = repositoy.findById(id)
                   .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));
        // actualizamos los datos
        saveRole.setName(role.getName());
        saveRole.setDescription(role.getDescription());
        return repositoy.save(saveRole);
    }

    @Override
    public void deleteRoleById(Long id) {
        repositoy.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));

        repositoy.delete(id);
    }
}
