package red.social.interesescomunes.role.domain.model;


import lombok.*;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.role.domain.event.RoleCreatedEvent;
import red.social.interesescomunes.role.domain.event.RoleDeletedEvent;
import red.social.interesescomunes.role.domain.event.RoleUpdatedEvent;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    private Long id;
    private TypeRole name;
    private String description;

    // evento de crear un rol
    public void create(ApplicationEventPublisher eventPublisher) {
        eventPublisher.publishEvent(new RoleCreatedEvent(this));
    }

    // evento de actualizacion de un rol
    public void update(ApplicationEventPublisher eventPublisher) {
        eventPublisher.publishEvent(new RoleUpdatedEvent(this));
    }

    // evento de eliminacion de un rol
    public void delete(ApplicationEventPublisher eventPublisher) {
        eventPublisher.publishEvent(new RoleDeletedEvent(this));
    }
}
