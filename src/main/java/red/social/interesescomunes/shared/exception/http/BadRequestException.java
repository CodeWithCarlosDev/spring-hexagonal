package red.social.interesescomunes.shared.exception.http;

/*
    Ocurre cuando la solicitud enviada al servidor es incorrecta o malformada.
*/
public class BadRequestException extends RuntimeException{
    private static final String DESCRIPTION = "Bad Request Exception (400)";
    private final String code;

    public BadRequestException(String detail, String code){
        super(DESCRIPTION + ": " + detail);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
