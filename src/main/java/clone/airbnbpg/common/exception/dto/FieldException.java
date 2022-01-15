package clone.airbnbpg.common.exception.dto;

import lombok.Data;

@Data
public class FieldException extends CommonException {

    private String field;

    public FieldException(String field, String cause) {
        super(cause);
        this.field = field;
    }

}
