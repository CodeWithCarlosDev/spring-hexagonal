package red.social.interesescomunes.shared.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private final String exception;
    private final String code;
    private final String message;
    private final String path;
    private final List<String> details;
    private final LocalDateTime timestamp;
}
