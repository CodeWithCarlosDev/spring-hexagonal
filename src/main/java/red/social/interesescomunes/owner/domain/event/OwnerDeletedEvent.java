package red.social.interesescomunes.owner.domain.event;

import red.social.interesescomunes.owner.domain.model.Owner;

public class OwnerDeletedEvent {
    private final Owner owner;

    public OwnerDeletedEvent(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }
}
