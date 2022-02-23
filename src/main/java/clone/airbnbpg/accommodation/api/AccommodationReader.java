package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.common.exception.accommodation.AccommodationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class AccommodationReader {

    private final AccommodationRepository accommodationRepository;

    public Accommodation findById(long accommodationId) {
        return accommodationRepository.findById(accommodationId)
                .orElseThrow(() -> new AccommodationNotFoundException("해당 숙소를 찾을 수 없습니다."));
    }
}
