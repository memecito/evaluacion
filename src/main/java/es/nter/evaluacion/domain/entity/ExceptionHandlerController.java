package es.nter.evaluacion.domain.entity;


import es.nter.evaluacion.execption.NotFounException;
import es.nter.evaluacion.execption.UnprocesableEntityException;
import es.nter.evaluacion.presentation.dto.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = {NotFounException.class})
    public ResponseEntity<CustomError> handleEntityNotFound(RuntimeException ex) {
        CustomError customError = new CustomError(
                HttpStatus.NOT_FOUND.value(),
                "Entidad no encontrada",
                ex.getMessage()
        );
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UnprocesableEntityException.class})
    public ResponseEntity<CustomError> handleUnprocesableEntity(RuntimeException ex) {
        CustomError customError = new CustomError(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "NO procesable accion",
                ex.getMessage()
        );
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> handleValidationException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String key = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(key, message);
                }
        );


        CustomError customError = new CustomError(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Faltan campos",
                errors.toString()
        );
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
