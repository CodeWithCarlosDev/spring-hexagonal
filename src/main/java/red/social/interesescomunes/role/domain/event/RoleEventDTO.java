package red.social.interesescomunes.role.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEventDTO {
    private Long id;
    private TypeRole name;
    private String description;

    public static RoleEventDTO create(Role role){
        return RoleEventDTO.builder()
            .id(role.getId())
            .name(role.getName())
            .description(role.getDescription())
            .build();
    }
}
