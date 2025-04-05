package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public class CategoryUpdatedEvent {
    private final CategoryEventDTO category;

    public CategoryUpdatedEvent(Category category) {
        this.category = CategoryEventDTO.create(category);
    }

    public CategoryEventDTO getCategory() {
        return this.category;
    }
}
