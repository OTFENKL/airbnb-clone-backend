package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
public class AccommodationWriter {

    private final AccommodationRepository accommodationRepository;

    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    public void delete(Accommodation accommodation) {
        accommodation.deleteActive();
    }
}
