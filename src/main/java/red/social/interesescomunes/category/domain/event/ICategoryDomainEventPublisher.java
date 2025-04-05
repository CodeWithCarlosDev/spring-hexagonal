package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public interface ICategoryDomainEventPublisher {
    void publishCategoryCreated(Category category);
    void publishCategoryUpdated(Category category);
    void publishCategoryDeleted(Category category);
}
