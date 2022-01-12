package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.accommodation.web.AccommodationDto;
import clone.airbnbpg.common.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AccommodationServiceTest extends BaseTest {

    @MockBean
    AccommodationRepository mockAccommodationRepository;

    @Autowired
    AccommodationService accommodationService;

    @Test
    void 숙소_정상_등록() {
        AccommodationDto accommodationDto = createInstance(AccommodationDto.class);
        Accommodation mockAccommodation = accommodationDto.toEntity();

        when(mockAccommodationRepository.save(any(Accommodation.class))).thenReturn(mockAccommodation);

        Accommodation responseBody = (Accommodation) accommodationService.createAccommodation(accommodationDto).getBody();

        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getName()).isNotNull();
        assertThat(responseBody.getAddress()).isNotNull();
        assertThat(responseBody.getBasicPrice()).isNotNull();
        assertThat(responseBody.getDescription()).isNotNull();
    }
}