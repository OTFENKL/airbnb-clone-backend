package clone.airbnbpg.common.exception;

import clone.airbnbpg.common.exception.dto.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> commonValid(BindingResult bindingResult) {
        return new ResponseEntity(new CommonException(extractErrorMsg(bindingResult)), HttpStatus.BAD_REQUEST);
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
