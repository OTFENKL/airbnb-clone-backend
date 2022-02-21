package clone.airbnbpg.accommodation.api;

import clone.airbnbpg.accommodation.Accommodation;
import clone.airbnbpg.accommodation.web.AccommodationReq;
import clone.airbnbpg.accommodation.web.AccommodationRes;
import clone.airbnbpg.common.converter.RabbitSender;
import org.springframework.stereotype.Service;

@Service
public record AccommodationService(AccommodationReader accommodationReader, AccommodationWriter accommodationWriter, RabbitSender rabbitSender) {

    public AccommodationRes createAccommodation(AccommodationReq accommodationDto) {
        Accommodation accommodation = accommodationDto.toEntity();
        Accommodation savedAccommodation = accommodationWriter.save(accommodation);
        AccommodationRes accommodationResponseDto = AccommodationRes.of(savedAccommodation);
        rabbitSender.send(accommodationResponseDto);

        return accommodationResponseDto;
    }

    public AccommodationRes updateAccommodation(long accommodationId, AccommodationReq accommodationDto) {
        Accommodation accommodation = accommodationReader.findById(accommodationId);
        Accommodation savedAccommodation = accommodationDto.toEntity(accommodation);

        return AccommodationRes.of(savedAccommodation);

    }

    public void removeAccommodation(long accommodationId) {
        Accommodation accommodation = accommodationReader.findById(accommodationId);
        accommodationWriter.delete(accommodation);
    }
}
