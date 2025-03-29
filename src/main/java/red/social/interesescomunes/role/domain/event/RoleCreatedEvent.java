package red.social.interesescomunes.role.domain.event;

import red.social.interesescomunes.role.domain.model.Role;

public class RoleCreatedEvent {
    private final RoleEventDTO role;

    public RoleCreatedEvent(Role role){
        this.role = RoleEventDTO.create(role);
    }

    public RoleEventDTO getRole(){
        return this.role;
    }
}
