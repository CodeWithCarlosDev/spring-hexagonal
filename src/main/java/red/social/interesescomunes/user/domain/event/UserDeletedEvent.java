package red.social.interesescomunes.user.domain.event;

import red.social.interesescomunes.user.domain.model.User;

public class UserDeletedEvent {
    private final UserEventDTO user;

    public UserDeletedEvent(User user){
        this.user = UserEventDTO.create(user);
    }

    public UserEventDTO getUser(){
        return this.user;
    }
}
