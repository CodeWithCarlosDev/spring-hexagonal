package red.social.interesescomunes.user.infrastructure.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import red.social.interesescomunes.role.domain.event.RoleCreatedEvent;
import red.social.interesescomunes.role.domain.event.RoleDeletedEvent;
import red.social.interesescomunes.role.domain.event.RoleUpdatedEvent;
import red.social.interesescomunes.user.domain.event.UserCreatedEvent;
import red.social.interesescomunes.user.domain.event.UserDeletedEvent;
import red.social.interesescomunes.user.domain.event.UserUpdatedEvent;

@Component
public class UserEventListener {
    @EventListener
    public void handleUserCreated(UserCreatedEvent event){
        System.out.println("Usuario creado: " + event.getUser().getFirstName() + " " + event.getUser().getLastName());
    }

    @EventListener
    public void handleUserUpdated(UserUpdatedEvent event){
        System.out.println("Usuario actualizado: " + event.getUser().getFirstName() + " " + event.getUser().getLastName());
    }

    @EventListener
    public void handleUserDeleted(UserDeletedEvent event) {
        System.out.println("Usuario eliminado: " + event.getUser().getFirstName() + " " + event.getUser().getLastName());
    }
}
