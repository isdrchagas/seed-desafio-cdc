package cdc.dev.eficiente.cdc;

import cdc.dev.eficiente.cdc.author.AuthorController;
import cdc.dev.eficiente.cdc.category.CategoryController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice(assignableTypes = {AuthorController.class, CategoryController.class})
public class RequestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Set<RequestValidationErrorDTO> handle(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors()
                .stream()
                .map(RequestValidationErrorDTO::new)
                .collect(Collectors.toSet());
    }

    public record RequestValidationErrorDTO(String field, String error) {
        RequestValidationErrorDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
