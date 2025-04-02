package red.social.interesescomunes.user.infrastructure.input.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.role.infrastructure.input.api.dto.response.RoleResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private List<RoleResponse> roles;
}
