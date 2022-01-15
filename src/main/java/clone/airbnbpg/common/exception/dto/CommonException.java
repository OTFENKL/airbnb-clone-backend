package clone.airbnbpg.common.exception.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonException {

    private String cause;

    public CommonException(String cause) {
        this.cause = cause;
    }
}
