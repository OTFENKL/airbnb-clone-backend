package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import clone.airbnbpg.common.exception.dto.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class AccommodationReader {

    private final AccommodationRepository accommodationRepository;

    public Accommodation findById(long accommodationId) {
        return accommodationRepository.findById(accommodationId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "해당 숙소를 찾을 수 없습니다."));
    }
}
