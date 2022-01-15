package clone.airbnbpg.common.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String suite;

    @Builder
    public Address(
            @NotBlank String country,
            @NotBlank String city,
            @NotBlank String postalCode,
            @NotBlank String suite) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.suite = suite;
    }
}
