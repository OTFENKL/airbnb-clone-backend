package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.accommodation.web.AccommodationReq;
import clone.airbnbpg.accommodation.web.AccommodationRes;
import clone.airbnbpg.common.BaseTest;
import clone.airbnbpg.common.entity.ActiveType;
import clone.airbnbpg.common.exception.dto.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static clone.airbnbpg.common.entity.ActiveType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
class AccommodationServiceTest extends BaseTest {

    @MockBean
    AccommodationRepository mockAccommodationRepository;

    @Autowired
    AccommodationService accommodationService;

    @Test
    void 숙소_정상_등록() {
        AccommodationReq accommodationDto = createInstance(AccommodationReq.class);
        Accommodation mockAccommodation = accommodationDto.toEntity();

        when(mockAccommodationRepository.save(any(Accommodation.class))).thenReturn(mockAccommodation);

        AccommodationRes responseBody = accommodationService.createAccommodation(accommodationDto);

        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getName()).isNotNull();
        assertThat(responseBody.getAddress()).isNotNull();
        assertThat(responseBody.getBasicPrice()).isNotNull();
        assertThat(responseBody.getDescription()).isNotNull();
    }

}