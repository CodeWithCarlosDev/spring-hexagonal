package red.social.interesescomunes.role.infrastructure.output.persistence.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.infrastructure.output.persistence.mysql.entity.RoleEntity;

import java.util.Optional;

@Repository
public interface IRoleJpaRepository extends CrudRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(TypeRole name); // Nuevo método
}
