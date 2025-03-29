package red.social.interesescomunes.role.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.role.application.output.IRolePersistencePort;
import red.social.interesescomunes.role.domain.event.IRoleDomainEventPublisher;
import red.social.interesescomunes.role.domain.exception.RoleNotFoundException;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleServicePort {
    private final IRolePersistencePort repository;
    private final IRoleDomainEventPublisher eventPublisher;

    public RoleServiceImpl(IRolePersistencePort repositoy, IRoleDomainEventPublisher eventPublisher) {
        this.repository = repositoy;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Role> findAllRoles() {
        return repository.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));
    }

    @Override
    @Transactional
    public Role createRole(Role role) {
        Role roleCreated = repository.save(role);
        roleCreated.create(this.eventPublisher);
        return roleCreated;
    }

    @Override
    @Transactional
    public Role updateRole(Long id, Role role) {
        Role databaseRole = repository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));
        // actualizamos los datos
        databaseRole.setName(role.getName());
        databaseRole.setDescription(role.getDescription());
        // guardamos y publica el evento
        Role roleUpdated = repository.save(databaseRole);
        roleUpdated.update(this.eventPublisher);
        return roleUpdated;
    }

    @Override
    @Transactional
    public void deleteRoleById(Long id) {
        Role role = repository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException("No se encontro un rol con el id " + id));

        repository.delete(id);
        role.delete(this.eventPublisher);
    }
}
