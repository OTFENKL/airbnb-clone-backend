package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.accommodation.web.AccommodationDto;
import clone.airbnbpg.accommodation.web.AccommodationRes;
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

    public ResponseEntity<?> createAccommodation(AccommodationDto accommodationDto) {
        Accommodation accommodation = accommodationDto.toEntity();
        Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        return new ResponseEntity<>(AccommodationRes.of(savedAccommodation), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAccommodation(long accommodationId, AccommodationDto accommodationDto) {
        Accommodation accommodation = accommodationRepository.findById(accommodationId)
                .orElseThrow(RuntimeException::new);

        Accommodation savedAccommodation = accommodationDto.toEntity(accommodation);

        return new ResponseEntity<>(AccommodationRes.of(savedAccommodation), HttpStatus.OK);

    }
}
