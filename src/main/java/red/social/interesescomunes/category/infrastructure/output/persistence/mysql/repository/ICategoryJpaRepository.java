package red.social.interesescomunes.category.infrastructure.output.persistence.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import red.social.interesescomunes.category.infrastructure.output.persistence.mysql.entity.CategoryEntity;

import java.util.Optional;

public interface ICategoryJpaRepository extends CrudRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}