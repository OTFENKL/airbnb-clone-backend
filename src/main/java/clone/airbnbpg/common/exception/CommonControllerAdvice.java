package clone.airbnbpg.common.exception;

import clone.airbnbpg.common.exception.accommodation.AccommodationNotFoundException;
import clone.airbnbpg.common.exception.dto.CommonErrorsRes;
import clone.airbnbpg.common.exception.dto.FieldErrorRes;
import clone.airbnbpg.common.exception.member.MemberNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static clone.airbnbpg.common.exception.dto.CommonErrorRes.*;
import static clone.airbnbpg.common.web.ControllerSupport.*;

@RestControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException e) {
        return badRequest(of(extractErrorMsg(e.getBindingResult())));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolation(ConstraintViolationException e) {
        CommonErrorsRes<FieldErrorRes> result = new CommonErrorsRes<>();

        for (ConstraintViolation cv : e.getConstraintViolations()) {
            String field = cv.getPropertyPath().toString();
            String cause = cv.getMessage();

            result.add(new FieldErrorRes(field, cause));
        }

        return badRequest(result);
    }

    @ExceptionHandler(value = AccommodationNotFoundException.class)
    public ResponseEntity<?> accommodationNotFound(AccommodationNotFoundException e) {
        return notFound(of(e.getMessage()));
    }

    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<?> memberNotFound(MemberNotFoundException e) {
        return notFound(of(e.getMessage()));
    }

    private String extractErrorMsg(BindingResult bindingResult) {
        return bindingResult.getFieldError().getDefaultMessage();
    }

    private List<String> extractErrorMsgs(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());
    }
}
