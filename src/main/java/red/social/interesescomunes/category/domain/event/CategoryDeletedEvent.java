package red.social.interesescomunes.category.domain.event;

import red.social.interesescomunes.category.domain.model.Category;

public class CategoryDeletedEvent {
    private final Category category;

    public CategoryDeletedEvent(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return this.category;
    }
}
