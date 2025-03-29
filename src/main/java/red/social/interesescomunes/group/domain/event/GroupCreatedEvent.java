package red.social.interesescomunes.group.domain.event;

import red.social.interesescomunes.group.domain.model.Group;

public class GroupCreatedEvent {
    private final Group group;

    public GroupCreatedEvent( Group group){
        this.group = group;
    }

    public Group getGroup(){
        return this.group;
    }
}
