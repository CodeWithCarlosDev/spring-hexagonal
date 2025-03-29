package red.social.interesescomunes.role.infrastructure.input.api.dto.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorResponse {
    private final String code;
    private final String message;
    private final List<String> details;
    private final LocalDateTime timestamp;
}
