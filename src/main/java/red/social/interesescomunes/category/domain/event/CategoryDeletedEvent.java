package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public class CategoryDeletedEvent {
    private final CategoryEventDTO category;

    public CategoryDeletedEvent(Category category) {
        this.category = CategoryEventDTO.create(category);
    }

    public CategoryEventDTO getCategory() {
        return this.category;
    }
}
