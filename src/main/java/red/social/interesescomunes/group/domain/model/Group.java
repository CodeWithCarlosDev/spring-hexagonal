package red.social.interesescomunes.group.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.category.domain.model.Category;
import red.social.interesescomunes.group.domain.event.GroupCreatedEvent;
import red.social.interesescomunes.group.domain.event.GroupDeletedEvent;
import red.social.interesescomunes.group.domain.event.GroupUpdatedEvent;
import red.social.interesescomunes.owner.domain.model.Owner;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Group {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String imageUrl;
    private Category category;
    private Owner owner;
    private GroupStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // evento de crear un rol
    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent( new GroupCreatedEvent(this));
    }

    // evento de actualizacion de un rol
    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new GroupUpdatedEvent(this));
    }

    // evento de eliminacion de un rol
    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new GroupDeletedEvent(this));
    }
}
