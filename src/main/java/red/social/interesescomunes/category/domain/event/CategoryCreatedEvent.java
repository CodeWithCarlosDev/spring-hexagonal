package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public class CategoryCreatedEvent {
    private final Category category;

    public CategoryCreatedEvent(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return this.category;
    }
}
