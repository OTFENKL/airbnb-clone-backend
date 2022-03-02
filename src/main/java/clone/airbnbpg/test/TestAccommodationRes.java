package clone.airbnbpg.test;

import clone.airbnbpg.accommodation.AccommodationType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
@NoArgsConstructor
public class TestAccommodationRes {

    private Long id;

    private String name;

    private String description;

    private String address;

    private int personCount;

    private List<String> imagePath;

    private long basicPrice;

    private AccommodationType type;

    private double rating;

    private int reviewCount;

    private TestOptionRes option;

    private String latitude;

    private String longitude;

    @Builder
    public TestAccommodationRes(Long id, String name, String description, String address, int personCount, List<String> imagePath, long basicPrice, AccommodationType type, double rating, int reviewCount, TestOptionRes option, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.personCount = personCount;
        this.imagePath = imagePath;
        this.basicPrice = basicPrice;
        this.type = type;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.option = option;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static List<TestAccommodationRes> creates(int pageSize, int pageNumber) {
        TestAccommodationRes[] accommodations = createBaseAccommodationListRes();

        System.out.println(Arrays.toString(accommodations));
        int offset = (pageSize * pageNumber);

        System.out.println("pageSize = " + pageSize);
        System.out.println("pageNumber = " + pageNumber);
        List<TestAccommodationRes> result = new ArrayList<>();
        for (int i = offset; i < (offset + pageSize); i++) {
            TestAccommodationRes accommodation = accommodations[i];
            result.add(accommodation);
        }

        System.out.println("result = " + result);

        return result;
    }

    private static TestAccommodationRes of(long idx) {
        Random random = new Random();

        return TestAccommodationRes.builder()
                .id(idx)
                .name("name" + idx)
                .description("description" + idx)
                .personCount(random.nextInt(5000))
                .imagePath(List.of("imagePath" + idx))
                .basicPrice(random.nextLong(10000000000L))
                .address("address" + idx)
                .type(AccommodationType.APARTMENT)
                .rating(Double.parseDouble(String.format("%.1f", random.nextDouble(5))))
                .reviewCount(random.nextInt(5000))
                .option(TestOptionRes.of())
                .latitude("latitude" + idx)
                .longitude("longitude" + idx)
                .build();
    }

    private static TestAccommodationRes[] createBaseAccommodationListRes() {
        TestAccommodationRes[] accommodations = new TestAccommodationRes[1000];

        for (int i = 0; i < 1000; i++) {
            accommodations[i] = of(i + 1);
        }

        return accommodations;
    }
}
