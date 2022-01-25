package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.accommodation.web.AccommodationReq;
import clone.airbnbpg.accommodation.web.AccommodationRes;
import clone.airbnbpg.common.converter.RabbitSender;
import clone.airbnbpg.common.exception.dto.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    private final RabbitSender rabbitSender;

    public ResponseEntity<?> createAccommodation(AccommodationReq accommodationDto) {
        Accommodation accommodation = accommodationDto.toEntity();
        Accommodation savedAccommodation = accommodationRepository.save(accommodation);
        AccommodationRes accommodationResponseDto = AccommodationRes.of(savedAccommodation);
        rabbitSender.send(accommodationResponseDto);

        return new ResponseEntity<>(accommodationResponseDto, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAccommodation(long accommodationId, AccommodationReq accommodationDto) {
        Accommodation accommodation = accommodationRepository.findById(accommodationId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "해당 숙소를 찾을 수 없습니다."));

        Accommodation savedAccommodation = accommodationDto.toEntity(accommodation);

        return new ResponseEntity<>(AccommodationRes.of(savedAccommodation), HttpStatus.OK);

    }

    public ResponseEntity<?> removeAccommodation(long accommodationId) {
        Accommodation accommodation = accommodationRepository.findById(accommodationId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "해당 숙소를 찾을 수 없습니다."));

        accommodation.deleteActive();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
