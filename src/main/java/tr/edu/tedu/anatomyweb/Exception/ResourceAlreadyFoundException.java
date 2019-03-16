package tr.edu.tedu.anatomyweb.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceAlreadyFoundException extends RuntimeException {
    public ResourceAlreadyFoundException(String message) {
        super(message);
    }

    public ResourceAlreadyFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}