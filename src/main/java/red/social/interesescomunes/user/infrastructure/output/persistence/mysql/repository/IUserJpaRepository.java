package red.social.interesescomunes.user.infrastructure.output.persistence.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.social.interesescomunes.user.infrastructure.output.persistence.mysql.entity.UserEntity;

@Repository
public interface IUserJpaRepository  extends CrudRepository<UserEntity,Long> {
}
