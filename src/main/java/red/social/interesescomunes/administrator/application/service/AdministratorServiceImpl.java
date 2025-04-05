package red.social.interesescomunes.administrator.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.social.interesescomunes.administrator.application.input.IAdministratorServicePort;
import red.social.interesescomunes.administrator.application.output.IAdministratorPersistencePort;
import red.social.interesescomunes.administrator.domain.event.IAdministratorDomainEventPublisher;
import red.social.interesescomunes.administrator.domain.model.Administrator;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.domain.exception.UserNotFoundException;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdministratorServiceImpl implements IAdministratorServicePort {
    private final IAdministratorPersistencePort repository;
    private final IAdministratorDomainEventPublisher eventPublisher;
    private final IRoleServicePort roleServicePort;

    public AdministratorServiceImpl(IAdministratorPersistencePort repository, IAdministratorDomainEventPublisher eventPublisher, IRoleServicePort roleServicePort) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
        this.roleServicePort = roleServicePort;
    }

    @Override
    public List<Administrator> findAllAdministrators() {
        return this.repository.findAll();
    }

    @Override
    public Administrator findAdministratorById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un administrador con el id " + id));
    }

    @Override
    @Transactional
    public Administrator createAdministrator(Administrator administrator) {
        Role role = this.roleServicePort.findRoleByType(TypeRole.ADMINISTRADOR.name());

        User user = administrator.getUser();
        user.setRoles(List.of(role));
        user.setCreatedAt(LocalDateTime.now());

        administrator.setStartDate(LocalDateTime.now());
        administrator.setUser(user);

        // Guardamos y publicamos el evento
        Administrator administratorCreated = this.repository.save(administrator);
        administratorCreated.create(this.eventPublisher);
        return administratorCreated;
    }

    @Override
    @Transactional
    public Administrator updateAdministrator(Long id, Administrator administrator) {
        User user = administrator.getUser();
        Administrator existingAdministrator = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un administrador con el id " + id));

        // Actualizamos los datos del usuario
        existingAdministrator.getUser().setFirstName(user.getFirstName());
        existingAdministrator.getUser().setLastName(user.getLastName());
        existingAdministrator.getUser().setAddress(user.getAddress());
        existingAdministrator.getUser().setEmail(user.getEmail());
        existingAdministrator.getUser().setPassword(user.getPassword());
        existingAdministrator.getUser().setUpdatedAt(LocalDateTime.now());

        // Guardamos y publicamos el evento
        Administrator administratorUpdated = this.repository.save(existingAdministrator);
        administratorUpdated.update(this.eventPublisher);
        return administratorUpdated;
    }

    @Override
    public void deleteAdministratorById(Long id) {
        Administrator existingAdministrator = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un administrador con el id " + id));

        // Eliminamos y publicamos el evento
        this.repository.delete(existingAdministrator.getId());
        existingAdministrator.delete(this.eventPublisher);
    }
}
