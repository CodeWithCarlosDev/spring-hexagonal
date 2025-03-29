package red.social.interesescomunes.role.infrastructure.input.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.role.domain.enums.TypeRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    @NotNull(message = "El tipo del rol es requerido.")
    private TypeRole name;
    @NotNull(message = "La descripcion del rol es requerido.")
    private String description;
}
