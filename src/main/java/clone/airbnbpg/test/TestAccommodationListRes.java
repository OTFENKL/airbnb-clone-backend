package clone.airbnbpg.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TestAccommodationListRes {

    private List<TestAccommodationRes> accommodationResList;

    private int pageNumber;

    private int pageSize;

    private long totalCount;

    @Builder
    public TestAccommodationListRes(List<TestAccommodationRes> accommodationResList, int pageNumber, int pageSize, long totalCount) {
        this.accommodationResList = accommodationResList;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
}
