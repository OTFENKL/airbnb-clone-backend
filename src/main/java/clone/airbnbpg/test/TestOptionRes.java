package clone.airbnbpg.test;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class TestOptionRes {

    private Map<String, List<String>> optionDetails;

    public TestOptionRes(Map<String, List<String>> optionDetails) {
        this.optionDetails = optionDetails;
    }

    public static TestOptionRes of() {
        return new TestOptionRes(createOptionDetails());
    }

    private static Map<String, List<String>> createOptionDetails() {
        Map<String, List<String>> optionDetails = new HashMap<>();
        optionDetails.put("아름다운 전망", List.of("안뜰 전망", "정원 전망"));
        optionDetails.put("욕실", List.of("헤어드라이어", "샴푸", "보디클렌저", "온수"));
        optionDetails.put("침실 및 세탁 시설", List.of("세탁기", "옷걸이", "침구", "암막 커튼"));
        optionDetails.put("엔터테이먼트", List.of("TV + 일반 케이블 TV"));
        optionDetails.put("냉난방", List.of("에어컨", "난방"));

        return optionDetails;
    }
}
