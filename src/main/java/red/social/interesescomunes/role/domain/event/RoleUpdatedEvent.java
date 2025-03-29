package red.social.interesescomunes.role.domain.event;

import red.social.interesescomunes.role.domain.model.Role;

public class RoleUpdatedEvent {
    private final RoleEventDTO role;

    public RoleUpdatedEvent(Role role){
        this.role = RoleEventDTO.create(role);
    }

    public RoleEventDTO getRole(){
        return this.role;
    }
}
