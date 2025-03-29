package red.social.interesescomunes.member.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import red.social.interesescomunes.member.domain.event.MemberCreatedEvent;
import red.social.interesescomunes.member.domain.event.MemberDeletedEvent;
import red.social.interesescomunes.member.domain.event.MemberUpdatedEvent;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private Long id;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private MemberStatus status;

    public void create(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new MemberCreatedEvent(this));
    }

    public void update(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new MemberUpdatedEvent(this));
    }

    public void delete(ApplicationEventPublisher eventPublisher){
        eventPublisher.publishEvent(new MemberDeletedEvent(this));
    }
}
