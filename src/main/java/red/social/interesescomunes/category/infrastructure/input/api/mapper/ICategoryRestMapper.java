package red.social.interesescomunes.category.infrastructure.input.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import red.social.interesescomunes.category.domain.model.Category;
import red.social.interesescomunes.category.infrastructure.input.api.dto.request.CategoryRequest;
import red.social.interesescomunes.category.infrastructure.input.api.dto.response.CategoryResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryRestMapper {
    @Mapping(target = "id", ignore = true)
    Category toDomain(CategoryRequest request);

    CategoryResponse toCategoryResponse(Category category);

    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
}
