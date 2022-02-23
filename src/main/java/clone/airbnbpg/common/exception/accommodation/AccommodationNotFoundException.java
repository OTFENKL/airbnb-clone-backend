package clone.airbnbpg.common.exception.accommodation;

public class AccommodationNotFoundException extends RuntimeException {

    public AccommodationNotFoundException(String message) {
        super(message);
    }
}