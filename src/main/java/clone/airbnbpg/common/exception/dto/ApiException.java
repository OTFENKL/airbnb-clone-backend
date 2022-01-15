package clone.airbnbpg.common.exception.dto;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private int httpStatus;

    public ApiException(HttpStatus httpStatus, String message)  {
        super(message);
        this.httpStatus = httpStatus.value();
    }

}
