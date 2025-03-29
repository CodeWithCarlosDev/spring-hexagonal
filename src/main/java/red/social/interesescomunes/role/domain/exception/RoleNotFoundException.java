package red.social.interesescomunes.role.domain.exception;

import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class RoleNotFoundException extends NotFoundException {
    private static final String code = ErrorCatalog.ROLE_NOT_FOUND.getCode();

    public RoleNotFoundException(String detail){
        super(ErrorCatalog.ROLE_NOT_FOUND.getMessage(), detail, code);
    }

}
