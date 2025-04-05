package red.social.interesescomunes.category.domain.event;


import red.social.interesescomunes.category.domain.model.Category;

public class CategoryCreatedEvent {
    private final CategoryEventDTO category;

    public CategoryCreatedEvent(Category category) {
        this.category = CategoryEventDTO.create(category);
    }

    public CategoryEventDTO getCategory() {
        return this.category;
    }
}
