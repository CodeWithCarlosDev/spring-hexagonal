package red.social.interesescomunes.owner.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.owner.domain.event.OwnerCreatedEvent;
import red.social.interesescomunes.owner.domain.event.OwnerDeletedEvent;
import red.social.interesescomunes.owner.domain.event.OwnerUpdatedEvent;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    private Long id;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private OwnerStatus status;

    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new OwnerCreatedEvent(this));
    }

    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new OwnerUpdatedEvent(this));
    }

    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new OwnerDeletedEvent(this));
    }
}
