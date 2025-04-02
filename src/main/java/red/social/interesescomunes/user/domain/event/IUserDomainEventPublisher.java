package red.social.interesescomunes.user.domain.event;

import red.social.interesescomunes.user.domain.model.User;

public interface IUserDomainEventPublisher {
    void publishUserCreated(User user);
    void publishUserUpdated(User user);
    void publishUserDeleted(User user);
}
