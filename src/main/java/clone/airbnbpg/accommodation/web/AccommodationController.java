package clone.airbnbpg.accommodation.web;

import clone.airbnbpg.accommodation.api.AccommodationService;
import clone.airbnbpg.common.web.ControllerSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static clone.airbnbpg.common.web.ControllerSupport.*;

@RequiredArgsConstructor
@RequestMapping("/accommodations")
@RestController
public class AccommodationController {

    private final AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<?> createAccommodation(@RequestBody @Valid AccommodationReq accommodationDto) {
        return create(accommodationService.createAccommodation(accommodationDto));
    }

    @PutMapping("/{accommodationId}")
    public ResponseEntity<?> updateAccommodation(@PathVariable long accommodationId, @RequestBody @Valid AccommodationReq accommodationDto) {
        return ok(accommodationService.updateAccommodation(accommodationId, accommodationDto));
    }

    @DeleteMapping("/{accommodationId}")
    public ResponseEntity<?> removeAccommodation(@PathVariable long accommodationId)    {
        accommodationService.removeAccommodation(accommodationId);

        return ok();
    }

}
