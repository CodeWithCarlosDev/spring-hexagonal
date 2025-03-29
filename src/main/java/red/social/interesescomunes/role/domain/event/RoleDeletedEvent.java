package red.social.interesescomunes.role.domain.event;

import red.social.interesescomunes.role.domain.model.Role;

public class RoleDeletedEvent {
    private final RoleEventDTO role;

    public RoleDeletedEvent(Role role){
        this.role = RoleEventDTO.create(role);
    }

    public RoleEventDTO getRole(){
        return this.role;
    }
}
