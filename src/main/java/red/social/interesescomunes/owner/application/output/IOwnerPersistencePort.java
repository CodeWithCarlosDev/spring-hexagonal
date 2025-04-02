package red.social.interesescomunes.owner.application.output;

import red.social.interesescomunes.owner.domain.model.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerPersistencePort {
    List<Owner> findAll();
    Optional<Owner> findById(Long id);
    Owner save(Owner owner);
    void delete(Long id);
}
