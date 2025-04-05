package red.social.interesescomunes.category.infrastructure.output.persistence.mapper;

import org.mapstruct.Mapper;
import red.social.interesescomunes.category.domain.model.Category;
import red.social.interesescomunes.category.infrastructure.output.persistence.mysql.entity.CategoryEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryPersistenceMapper {
    Category toDomain(CategoryEntity entity);
    CategoryEntity toEntity(Category domain);
    List<Category> toDomainList(List<CategoryEntity> entities);
}
