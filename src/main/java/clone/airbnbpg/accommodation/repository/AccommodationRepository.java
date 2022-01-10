package clone.airbnbpg.accommodation.repository;

import clone.airbnbpg.accommodation.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
