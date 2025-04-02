package red.social.interesescomunes.user.domain.exception;

import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class UserNotFoundException extends NotFoundException {
    private static final String code = ErrorCatalog.USER_NOT_FOUND.getCode();

    public UserNotFoundException(String detail){
        super(ErrorCatalog.USER_NOT_FOUND.getMessage(), detail, code);
    }
}
