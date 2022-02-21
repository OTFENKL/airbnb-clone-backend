package clone.airbnbpg.accommodation;

import clone.airbnbpg.common.entity.Address;
import clone.airbnbpg.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @NoArgsConstructor @ToString
@Entity
public class Accommodation extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "acc_id")
    private Long id;

    @NotBlank
    private String name;

    @Lob
    @NotNull
    private String description;

    @NotNull
    private Address address;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @Min(value = 1_000)
    private long basicPrice;

    @Min(value = 1)
    private int personCount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccommodationType type;

    @Builder
    public Accommodation(
            @NotBlank String name,
            @NotNull String description,
            @NotNull Address address,
            @NotBlank String latitude,
            @NotBlank String longitude,
            @Min(value = 1_000) long basicPrice,
            @Min(value = 1) int personCount,
            @NotNull AccommodationType type) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.basicPrice = basicPrice;
        this.personCount = personCount;
        this.type = type;
    }

}
