package red.social.interesescomunes.user.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.user.application.input.IUserServicePort;
import red.social.interesescomunes.user.application.output.IUserPersistencePort;
import red.social.interesescomunes.user.domain.event.IUserDomainEventPublisher;
import red.social.interesescomunes.user.domain.exception.UserNotFoundException;
import red.social.interesescomunes.user.domain.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements IUserServicePort {
    private final IUserPersistencePort repository;
    private final IRoleServicePort roleService;

    private final IUserDomainEventPublisher eventPublisher;

    public UserServiceImpl(IUserPersistencePort repository, IRoleServicePort roleService, IUserDomainEventPublisher eventPublisher) {
        this.repository = repository;
        this.roleService = roleService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<User> findAllUsers() {
        return this.repository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return null;
    }
/*
    @Override
    @Transactional
    public User createUser(User user) {
        User userCreated = this.repository.save(user);
        userCreated.create(this.eventPublisher);
        return userCreated;
    }
*/

    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser  = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
        // actualizamos los datos
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAddress(user.getAddress());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());
        return existingUser;
    }

/*
    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser  = this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
        // actualizamos los datos
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAddress(user.getAddress());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());
        // guardamos y publica el evento
        User userUpdated = this.repository.save(existingUser);
        userUpdated.update(this.eventPublisher);
        return userUpdated;
    }
*/
    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User existingUser  = this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el id "+ id));
        // eliminamos y publica el evento
        this.repository.delete(existingUser.getId());
        existingUser.delete(this.eventPublisher);
    }
}
