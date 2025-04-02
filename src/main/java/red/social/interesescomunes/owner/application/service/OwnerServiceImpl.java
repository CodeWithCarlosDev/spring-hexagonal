package red.social.interesescomunes.owner.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.social.interesescomunes.owner.application.input.IOwnerServicePort;
import red.social.interesescomunes.owner.application.output.IOwnerPersistencePort;
import red.social.interesescomunes.owner.domain.event.IOwnerDomainEventPublisher;
import red.social.interesescomunes.owner.domain.model.Owner;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.application.input.IUserServicePort;
import red.social.interesescomunes.user.domain.exception.UserNotFoundException;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OwnerServiceImpl implements IOwnerServicePort {
    private final IOwnerPersistencePort repository;
    private final IOwnerDomainEventPublisher eventPublisher;
    private final IRoleServicePort roleService;

    public OwnerServiceImpl(IOwnerPersistencePort repository, IOwnerDomainEventPublisher eventPublisher, IRoleServicePort roleService) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
        this.roleService = roleService;
    }

    @Override
    public List<Owner> findAllOwners() {
        return  this.repository.findAll();
    }

    @Override
    public Owner findOwnerById(Long id) {
        return this.repository.findById(id)
            .orElseThrow( ()-> new UserNotFoundException("No se encontro un miembro con el id " + id));
    }

    @Override
    @Transactional
    public Owner createOwner(Owner owner) {
        Role role = Role.builder()
                .name(TypeRole.MIEMBRO)
                .description("Usuario de la aplicacion que puede ser miembro de un grupo tematico.")
                .build();

        User user = owner.getUser();
        user.setRoles(List.of(role));
        user.setCreatedAt(LocalDateTime.now());

        owner.setStartDate(LocalDateTime.now());
        owner.setUser(user);
        System.out.println("ESTE ES EL USUARIO" + owner);
        // guardamos y publica el evento
        Owner ownerCreated = this.repository.save(owner);
        ownerCreated.create(this.eventPublisher);
        return ownerCreated;
    }

    @Override
    @Transactional
    public Owner updateOwner(Long id, Owner owner) {
        User user = owner.getUser();
        Owner existingOwner = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
        // actualizamos los datos
        existingOwner.getUser().setFirstName(user.getFirstName());
        existingOwner.getUser().setLastName(user.getLastName());
        existingOwner.getUser().setAddress(user.getAddress());
        existingOwner.getUser().setEmail(user.getEmail());
        existingOwner.getUser().setPassword(user.getPassword());
        existingOwner.getUser().setUpdatedAt(LocalDateTime.now());
        // guardamos y publica el evento
        Owner ownerUpdate = this.repository.save(existingOwner);
        ownerUpdate.update(this.eventPublisher);
        return ownerUpdate;
    }

    @Override
    public void deleteOwnerById(Long id) {
        Owner existingOwner = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
        // eliminamos y publica el evento
        this.repository.delete(existingOwner.getId());
        existingOwner.delete(this.eventPublisher);
    }
}
