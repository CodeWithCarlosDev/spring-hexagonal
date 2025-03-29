package red.social.interesescomunes.shared;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import red.social.interesescomunes.role.domain.exception.RoleNotFoundException;
import red.social.interesescomunes.role.infrastructure.input.api.dto.error.ErrorResponse;
import red.social.interesescomunes.utils.ErrorCatalog;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public ErrorResponse handleRoleNotFoundException(){
    return ErrorResponse.builder()
            .code(ErrorCatalog.ROLE_NOT_FOUND.getCode())
            .message(ErrorCatalog.ROLE_NOT_FOUND.getMessage())
            .timestamp(LocalDateTime.now())
            .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        List<String> listOfErrors = result.getFieldErrors()
            .stream()
            .map(fieldError -> fieldError.getDefaultMessage())
            .toList();

        return ErrorResponse.builder()
            .code(ErrorCatalog.INVALID_ROLE.getCode())
            .message(ErrorCatalog.INVALID_ROLE.getMessage())
            .details(listOfErrors)
            .timestamp(LocalDateTime.now())
            .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception){
        return ErrorResponse.builder()
            .code(ErrorCatalog.GENERIC_ERROR.getCode())
            .details(Collections.singletonList(exception.getMessage()))
            .timestamp(LocalDateTime.now())
            .build();
    }
}
