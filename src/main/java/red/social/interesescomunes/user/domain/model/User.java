package red.social.interesescomunes.user.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.domain.event.IUserDomainEventPublisher;
import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Role> roles;

    public void create(IUserDomainEventPublisher eventPublisher) {
        eventPublisher.publishUserCreated(this);
    }

    public void update(IUserDomainEventPublisher eventPublisher) {
        eventPublisher.publishUserUpdated(this);
    }

    public void delete(IUserDomainEventPublisher eventPublisher) {
        eventPublisher.publishUserDeleted(this);
    }
}
