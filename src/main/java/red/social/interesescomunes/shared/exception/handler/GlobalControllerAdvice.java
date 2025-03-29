package red.social.interesescomunes.shared.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import red.social.interesescomunes.role.domain.exception.RoleNotFoundException;
import red.social.interesescomunes.shared.exception.http.BadRequestException;
import red.social.interesescomunes.shared.exception.http.ForbiddenException;
import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.shared.exception.model.ErrorResponse;
import red.social.interesescomunes.utils.ErrorCatalog;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse badRequest(HttpServletRequest request, BadRequestException exception){
           return ErrorResponse.builder()
                .exception(exception.getClass().getSimpleName())
                .code(exception.getCode())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public ErrorResponse forbiddenRequest(HttpServletRequest request, ForbiddenException exception){
        return ErrorResponse.builder()
                .exception(exception.getClass().getSimpleName())
                .code(exception.getCode())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFoundRequest(HttpServletRequest request, NotFoundException exception){
        return ErrorResponse.builder()
            .exception(exception.getClass().getSimpleName())
            .code(exception.getCode())
            .message(exception.getMessage())
            .details(List.of(exception.getDetail()))
            .path(request.getRequestURI())
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
            .exception(exception.getClass().getSimpleName())
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
            .exception(exception.getClass().getSimpleName())
            .code(ErrorCatalog.GENERIC_ERROR.getCode())
            .details(Collections.singletonList(exception.getMessage()))
            .timestamp(LocalDateTime.now())
            .build();
    }
}
