package red.social.interesescomunes.administrator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.administrator.domain.event.AdministratorCreatedEvent;
import red.social.interesescomunes.administrator.domain.event.AdministratorDeletedEvent;
import red.social.interesescomunes.administrator.domain.event.AdministratorUpdatedEvent;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Administrator {
    private Long id;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private AdministratorStatus status;

    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new AdministratorCreatedEvent(this));
    }

    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new AdministratorUpdatedEvent(this));
    }

    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new AdministratorDeletedEvent(this));
    }

}
