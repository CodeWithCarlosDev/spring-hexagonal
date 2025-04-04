package red.social.interesescomunes.category.application.output;

import red.social.interesescomunes.category.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryPersistencePort {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Category save(Category category);
    void delete(Long id);
}
