package red.social.interesescomunes.member.infrastructure.input.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.owner.domain.enums.OwnerStatus;
import red.social.interesescomunes.user.domain.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private User user;
    private OwnerStatus status;
}
