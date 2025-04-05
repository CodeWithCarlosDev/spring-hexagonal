package red.social.interesescomunes.utils;

public enum ErrorCatalog  {
    ROLE_NOT_FOUND("ERROR_ROLE_001", "Role not found."),
    INVALID_ROLE("ERROR_ROLE_002", "Invalid role parameters."),
    GENERIC_ERROR("ERROR_GEN_001", "An unexpected error occurred."),

    CATEGORY_NOT_FOUND("ERROR_CATEGORY_001", "Category not found."),

    GROUP_NOT_FOUND("ERROR_GROUP_001", "Group not found."),
    INVALID_GROUP("ERROR_GROUP_002", "Invalid group parameters."),
    GROUP_ALREADY_EXISTS("ERROR_GROUP_003", "Group with this name already exists."),


    USER_NOT_FOUND("ERROR_USER_001", "User not found."),
    EMAIL_ALREADY_EXISTS("ERROR_USER_002", "Email already registered."),
    USER_ROLE_ALREADY_EXISTS("ERROR_USER_003", "User already has this role assigned."),
    USER_ROLE_NOT_FOUND("ERROR_USER_004", "User role relationship not found."),
    INVALID_USER("ERROR_USER_005", "Invalid user parameters.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
