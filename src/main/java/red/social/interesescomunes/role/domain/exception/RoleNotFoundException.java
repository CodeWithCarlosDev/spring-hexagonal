package red.social.interesescomunes.role.domain.exception;

public class RoleNotFoundException extends RuntimeException{
    private static final String DESCRIPTION = "Not Found Exception (404)";

    public RoleNotFoundException(String detail){
        super(DESCRIPTION + ": " + detail);
    }
}
