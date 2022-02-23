package clone.airbnbpg.common.web;

import clone.airbnbpg.common.exception.dto.CommonErrorsRes;
import clone.airbnbpg.common.exception.dto.CommonErrorRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerSupport {

    public static <T> ResponseEntity<?> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> ok(T body) {
        return ResponseEntity.ok(body);
    }

    public static <T> ResponseEntity<?> create(T body) {
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    public static ResponseEntity<?> badRequest(CommonErrorRes body) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> badRequest(CommonErrorsRes body) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> notFound(CommonErrorRes body) {
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> internalError(CommonErrorRes body) {
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
