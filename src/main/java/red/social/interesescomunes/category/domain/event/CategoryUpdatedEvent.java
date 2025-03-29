package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public class CategoryUpdatedEvent {
    private final Category category;

    public CategoryUpdatedEvent(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return this.category;
    }
}
