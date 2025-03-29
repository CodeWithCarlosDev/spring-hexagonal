package red.social.interesescomunes.administrator.domain.event;

import red.social.interesescomunes.administrator.domain.model.Administrator;

public class AdministratorUpdatedEvent {
    private final Administrator administrator;

    public AdministratorUpdatedEvent(Administrator administrator) {
        this.administrator = administrator;
    }

    public Administrator getOwner() {
        return administrator;
    }
}
