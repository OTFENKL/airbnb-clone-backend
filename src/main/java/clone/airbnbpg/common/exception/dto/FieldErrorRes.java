package clone.airbnbpg.common.exception.dto;

import lombok.Data;

@Data
public class FieldErrorRes extends CommonErrorRes {

    private String field;

    public FieldErrorRes(String field, String cause) {
        super(cause);
        this.field = field;
    }

}
