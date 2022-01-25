package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.AccommodationType;
import clone.airbnbpg.common.entity.Address;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AccommodationRes {

    private Long id;

    private String name;

    private String description;

    private Address address;

    private int personCount;

    private List<String> imagePath;

    private long basicPrice;

    private AccommodationType type;

    public static AccommodationRes of(Accommodation accommodation) {
        return AccommodationRes.builder()
                .id(accommodation.getId())
                .name(accommodation.getName())
                .description(accommodation.getDescription())
//                .address(accommodation.getAddress())
                .personCount(accommodation.getPersonCount())
                .basicPrice(accommodation.getBasicPrice())
                .type(accommodation.getType())
                .build();
    }

    @Builder
    public AccommodationRes(Long id, String name, String description, int personCount, List<String> imagePath, long basicPrice, AccommodationType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.personCount = personCount;
        this.imagePath = imagePath;
        this.basicPrice = basicPrice;
        this.type = type;
    }
}
