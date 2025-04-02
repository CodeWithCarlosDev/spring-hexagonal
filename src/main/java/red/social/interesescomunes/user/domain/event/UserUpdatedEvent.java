package red.social.interesescomunes.user.domain.event;

import red.social.interesescomunes.user.domain.model.User;

public class UserUpdatedEvent {
    private final UserEventDTO user;

    public UserUpdatedEvent(User user){
        this.user = UserEventDTO.create(user);
    }

    public UserEventDTO getUser(){
        return this.user;
    }
}
