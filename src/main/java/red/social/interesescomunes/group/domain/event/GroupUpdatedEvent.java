package red.social.interesescomunes.group.domain.event;

import red.social.interesescomunes.group.domain.model.Group;

public class GroupUpdatedEvent {
    private final Group group;

    public GroupUpdatedEvent( Group group){
        this.group = group;
    }

    public Group getGroup(){
        return this.group;
    }
}
