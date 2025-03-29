package red.social.interesescomunes.category.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.category.domain.event.CategoryCreatedEvent;
import red.social.interesescomunes.category.domain.event.CategoryDeletedEvent;
import red.social.interesescomunes.category.domain.event.CategoryUpdatedEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Long id;
    private String name;
    private String description;

    // evento de crear un rol
    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent( new CategoryCreatedEvent(this));
    }

    // evento de actualizacion de un rol
    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new CategoryUpdatedEvent(this));
    }

    // evento de eliminacion de un rol
    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new CategoryDeletedEvent(this));
    }
}
