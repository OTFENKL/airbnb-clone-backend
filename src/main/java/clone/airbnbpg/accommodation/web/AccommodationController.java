package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.api.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/accommodations")
@RestController
public class AccommodationController {

    private final AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<?> createAccommodation(@RequestBody @Valid AccommodationReq accommodationDto) {
        return accommodationService.createAccommodation(accommodationDto);
    }

    @PutMapping("/{accommodationId}")
    public ResponseEntity<?> updateAccommodation(@PathVariable long accommodationId, @RequestBody @Valid AccommodationReq accommodationDto) {
        return accommodationService.updateAccommodation(accommodationId, accommodationDto);
    }

    @DeleteMapping("/{accommodationId}")
    public ResponseEntity<?> removeAccommodation(@PathVariable long accommodationId)    {
        return accommodationService.removeAccommodation(accommodationId);
    }

}
