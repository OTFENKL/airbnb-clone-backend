package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.AccommodationType;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.common.BaseControllerTest;
import clone.airbnbpg.common.entity.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static clone.airbnbpg.accommodation.AccommodationType.*;
import static clone.airbnbpg.common.entity.ActiveType.ACTIVE;
import static clone.airbnbpg.common.entity.ActiveType.DELETE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class AccommodationControllerTest extends BaseControllerTest {

    @Autowired
    AccommodationController accommodationController;

    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void 숙소_등록_시_예외_발생_테스트() throws Exception {
        AccommodationReq accommodationDto = AccommodationReq.builder()
                        .build();

                mockMvc.perform(post("/accommodations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accommodationDto)))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andExpect(jsonPath("cause").isNotEmpty());
    }


    @Test
    void ACTIVETYPE의_기본값이_ACTIVE이다() throws Exception {
        AccommodationReq accommodationReq = AccommodationReq.builder()
                .name("숙소 이름")
                .description("숙소 설명")
                .address(createInstance(Address.class))
                .personCount(48)
                .type(HOTEL)
                .basicPrice(10000)
                .latitude("숙소 위도")
                .longitude("숙소 경도")
                .build();

        mockMvc.perform(post("/accommodations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accommodationReq)))
                .andDo(print())
                .andExpect(status().isCreated());

        Accommodation findAccommodation = accommodationRepository.findAll().get(0);

        assertThat(findAccommodation).isNotNull();
        assertThat(findAccommodation.getActiveType()).isEqualTo(ACTIVE);
    }

    @Test
    void 숙소_정상_삭제() throws Exception {
        Accommodation accommodation = createInstance(Accommodation.class);
        Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        Long accommodationId = savedAccommodation.getId();

        mockMvc.perform(delete("/accommodations/{accommodationId}", accommodationId))
                .andDo(print())
                .andExpect(status().isOk());

        Accommodation removedAccommodation = accommodationRepository.findById(accommodationId)
                .orElseThrow();

        assertThat(removedAccommodation).isNotNull();
        assertThat(removedAccommodation.getActiveType()).isEqualTo(DELETE);
    }
}