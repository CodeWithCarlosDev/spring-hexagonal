package red.social.interesescomunes.category.domain.exception;

import red.social.interesescomunes.shared.exception.http.NotFoundException;
import red.social.interesescomunes.utils.ErrorCatalog;

public class CategoryNotFoundException extends NotFoundException {
    private static final String code = ErrorCatalog.CATEGORY_NOT_FOUND.getCode();

    public CategoryNotFoundException(String detail) {
        super(ErrorCatalog.CATEGORY_NOT_FOUND.getMessage(), detail, code);
    }
}