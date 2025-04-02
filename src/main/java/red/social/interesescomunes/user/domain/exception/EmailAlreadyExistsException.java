package red.social.interesescomunes.user.domain.exception;

import red.social.interesescomunes.shared.exception.http.BadRequestException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class EmailAlreadyExistsException extends BadRequestException {
    private static final String code = ErrorCatalog.EMAIL_ALREADY_EXISTS.getCode();

    public EmailAlreadyExistsException(String email){
        super("El correo " + email + " ya está registrado", code);
    }
}
