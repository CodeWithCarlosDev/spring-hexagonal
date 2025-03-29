package red.social.interesescomunes.administrator.domain.event;

import red.social.interesescomunes.administrator.domain.model.Administrator;

public class AdministratorCreatedEvent {
    private final Administrator administrator;

    public AdministratorCreatedEvent(Administrator administrator) {
        this.administrator = administrator;
    }

    public Administrator getOwner() {
        return administrator;
    }
}
