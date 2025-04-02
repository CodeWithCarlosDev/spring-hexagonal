package red.social.interesescomunes.user.domain.event;

import red.social.interesescomunes.user.domain.model.User;

public class UserCreatedEvent {
    private final UserEventDTO user;

    public UserCreatedEvent(User user){
        this.user = UserEventDTO.create(user);
    }

    public UserEventDTO getUser(){
        return this.user;
    }
}
