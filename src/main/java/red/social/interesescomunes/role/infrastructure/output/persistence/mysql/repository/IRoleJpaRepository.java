package red.social.interesescomunes.role.infrastructure.output.persistence.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.social.interesescomunes.role.infrastructure.output.persistence.mysql.entity.RoleEntity;

@Repository
public interface IRoleJpaRepository extends CrudRepository<RoleEntity,Long> {
}
