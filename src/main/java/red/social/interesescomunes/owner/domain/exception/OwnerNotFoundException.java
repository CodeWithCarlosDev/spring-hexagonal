package red.social.interesescomunes.owner.domain.exception;

import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class OwnerNotFoundException extends NotFoundException {
    private static final String code = ErrorCatalog.USER_NOT_FOUND.getCode();

    public OwnerNotFoundException(String detail){
        super(ErrorCatalog.USER_NOT_FOUND.getMessage(), detail, code);
    }
}
