package co.com.spn.cun3.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
class ExceptionWrapper{
    private final String message;
    private final HttpStatus httpStatus;

    ExceptionWrapper(CredencialesInvalidasException exception){
        this.message = exception.getMessage();
        this.httpStatus = exception.getHttpStatus();
    }
}

@Getter
@Setter
public class CredencialesInvalidasException extends RuntimeException{
    private final String message;
    private final HttpStatus httpStatus;

    public CredencialesInvalidasException() {
        this.message = "Credenciales Invalidas";
        this.httpStatus = HttpStatus.UNAUTHORIZED;
    }

    public ExceptionWrapper getWrapper(){
        return new ExceptionWrapper(this);
    }
}
