package red.social.interesescomunes.role.domain.event;

import red.social.interesescomunes.role.domain.model.Role;

public interface IRoleDomainEventPublisher {
    void publishRoleCreated(Role role);
    void publishRoleUpdated(Role role);
    void publishRoleDeleted(Role role);
}
