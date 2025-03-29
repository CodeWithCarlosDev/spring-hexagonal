package red.social.interesescomunes.utils;

public enum ErrorCatalog  {
    ROLE_NOT_FOUND("ERROR_ROLE_001", "Role not found."),
    INVALID_ROLE("ERROR_ROLE_001", "Invalid role parameters."),
    GENERIC_ERROR("ERROR_GEN_001", "An unxpected error occrred.");

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
