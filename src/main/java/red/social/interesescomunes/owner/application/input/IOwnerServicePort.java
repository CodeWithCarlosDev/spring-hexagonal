package red.social.interesescomunes.owner.application.input;

import red.social.interesescomunes.owner.domain.model.Owner;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;

public interface IOwnerServicePort {
    List<Owner> findAllOwners();
    Owner findOwnerById(Long id);
    Owner createOwner(Owner owner);
    Owner updateOwner(Long id, Owner owner);
    void deleteOwnerById(Long id);
}
