package red.social.interesescomunes.group.domain.event;

import red.social.interesescomunes.group.domain.model.Group;

public class GroupDeletedEvent {
    private final Group group;

    public GroupDeletedEvent( Group group){
        this.group = group;
    }

    public Group getGroup(){
        return this.group;
    }
}
