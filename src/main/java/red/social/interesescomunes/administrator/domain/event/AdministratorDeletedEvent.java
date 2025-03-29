package red.social.interesescomunes.administrator.domain.event;

import red.social.interesescomunes.administrator.domain.model.Administrator;

public class AdministratorDeletedEvent {
    private final Administrator administrator;

    public AdministratorDeletedEvent(Administrator administrator) {
        this.administrator = administrator;
    }

    public Administrator getOwner() {
        return administrator;
    }
}
