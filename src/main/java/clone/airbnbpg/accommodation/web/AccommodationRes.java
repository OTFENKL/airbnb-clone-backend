package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.AccommodationType;
import clone.airbnbpg.common.entity.Address;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
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
                .address(accommodation.getAddress())
                .personCount(accommodation.getPersonCount())
                .basicPrice(accommodation.getBasicPrice())
                .type(accommodation.getType())
                .build();
    }
}
