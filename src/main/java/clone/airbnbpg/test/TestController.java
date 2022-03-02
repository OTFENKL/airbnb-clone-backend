package clone.airbnbpg.test;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/accommodations")
    public ResponseEntity<?> get(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        List<TestAccommodationRes> data = TestAccommodationRes.creates(pageSize, pageNumber);

        TestAccommodationListRes result = TestAccommodationListRes.builder()
                .accommodationResList(data)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .totalCount(1000)
                .build();

        return ResponseEntity.ok(result);
    }
}
