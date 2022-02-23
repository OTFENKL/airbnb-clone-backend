package clone.airbnbpg.common.exception.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommonErrorsRes<T extends CommonErrorRes> {

    private List<T> causes;

    public CommonErrorsRes(List<T> causes) {
        this.causes = causes;
    }

    public void add(T t) {
        causes.add(t);
    }
}
