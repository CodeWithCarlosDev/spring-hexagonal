package red.social.interesescomunes.user.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.domain.model.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEventDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private List<Role> roles;

    public static UserEventDTO create(User user){
        return  UserEventDTO.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .address(user.getAddress())
            .email(user.getEmail())
            .password(user.getPassword())
            .roles(user.getRoles())
            .build();
    }
}
