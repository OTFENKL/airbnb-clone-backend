package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.AccommodationType;
import clone.airbnbpg.common.entity.Address;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccommodationDto {

    @NotBlank(message = "이름은 공백이거나, null일 수 없습니다.")
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Address address;

    @Min(value = 1)
    private int personCount;

    private String accommodationType;

    private List<String> imagePath = new ArrayList<>();

    private long basicPrice;

    private AccommodationType type;

    @Builder
    public AccommodationDto(
            @NotBlank String name,
            String description,
            @NotNull Address address,
            @Min(value = 1) int personCount,
            String accommodationType,
            List<String> imagePath,
            int reviewCount,
            long basicPrice,
            AccommodationType type) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.personCount = personCount;
        this.accommodationType = accommodationType;
        this.imagePath = imagePath;
        this.basicPrice = basicPrice;
        this.type = type;
    }

    public Accommodation toEntity() {
        return Accommodation.builder()
                .name(name)
                .description(description)
                .address(address)
                .basicPrice(basicPrice)
                .personCount(personCount)
                .type(type)
                .build();
    }

    public Accommodation toEntity(Accommodation accommodation) {
        return Accommodation.builder()
                .name(accommodation.getName())
                .description(accommodation.getDescription())
                .address(accommodation.getAddress())
                .basicPrice(accommodation.getBasicPrice())
                .personCount(accommodation.getPersonCount())
                .type(accommodation.getType())
                .build();
    }
}
