package clone.airbnbpg.common.exception.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommonErrorRes {

    private String cause;

    public CommonErrorRes(String cause) {
        this.cause = cause;
    }

    public static CommonErrorRes of(String cause) {
        return new CommonErrorRes(cause);
    }
}
