package red.social.interesescomunes.user.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.domain.event.UserCreatedEvent;
import red.social.interesescomunes.user.domain.event.UserDeletedEvent;
import red.social.interesescomunes.user.domain.event.UserUpdatedEvent;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private List<Role> roles;

    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new UserCreatedEvent(this));
    }

    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new UserUpdatedEvent(this));
    }

    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new UserDeletedEvent(this));
    }
}
