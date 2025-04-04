package red.social.interesescomunes.owner.application.input;

import red.social.interesescomunes.member.domain.model.Member;
import red.social.interesescomunes.owner.domain.model.Owner;
import red.social.interesescomunes.role.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface IOwnerServicePort {
    List<Owner> findAllOwners();
    Owner findOwnerById(Long id);
    Optional<Owner> findOwnerByUserId(Long id);
    Owner createOwner(Owner owner);
    Owner updateOwner(Long id, Owner owner);
    void deleteOwnerById(Long id);
}
