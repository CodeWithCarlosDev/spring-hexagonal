package red.social.interesescomunes.user.infrastructure.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import red.social.interesescomunes.user.domain.event.IUserDomainEventPublisher;
import red.social.interesescomunes.user.domain.event.UserCreatedEvent;
import red.social.interesescomunes.user.domain.event.UserDeletedEvent;
import red.social.interesescomunes.user.domain.event.UserUpdatedEvent;
import red.social.interesescomunes.user.domain.model.User;

@Component
public class SpringUserEventPublisherImpl implements IUserDomainEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public SpringUserEventPublisherImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishUserCreated(User user) {
        eventPublisher.publishEvent(new UserCreatedEvent(user));
    }

    @Override
    public void publishUserUpdated(User user) {
        eventPublisher.publishEvent(new UserUpdatedEvent(user));
    }

    @Override
    public void publishUserDeleted(User user) {
        eventPublisher.publishEvent(new UserDeletedEvent(user));
    }
}
