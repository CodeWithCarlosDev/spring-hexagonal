package red.social.interesescomunes.group.domain.exception;

import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class GroupNotFoundException extends NotFoundException {
    private static final String code = ErrorCatalog.GROUP_NOT_FOUND.getCode();

    public GroupNotFoundException(String detail) {
        super(ErrorCatalog.GROUP_NOT_FOUND.getMessage(), detail, code);
    }
}
