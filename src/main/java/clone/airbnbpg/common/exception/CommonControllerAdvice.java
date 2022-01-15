package clone.airbnbpg.common.exception;

import clone.airbnbpg.common.exception.dto.CommonException;
import clone.airbnbpg.common.exception.dto.FieldException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException e) {
        return new ResponseEntity(new CommonException(extractErrorMsg(e.getBindingResult())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolation(ConstraintViolationException e) {
        List<FieldException> result = new ArrayList<>();
        for (ConstraintViolation cv : e.getConstraintViolations()) {
            String field = cv.getPropertyPath().toString();
            String cause = cv.getMessage();

            result.add(new FieldException(field, cause));
        }
        
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
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
