package clone.airbnbpg.common.exception.dto;

import clone.airbnbpg.common.exception.CommonControllerAdvice;
import lombok.Data;

@Data
public class CommonException {

    private String cause;

    public CommonException(String cause) {
        this.cause = cause;
    }
}
