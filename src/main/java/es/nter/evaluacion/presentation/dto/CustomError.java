package es.nter.evaluacion.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomError {

    private LocalDateTime timestamp;
    private int httpCode;
    private String error;
    private String message;

    public CustomError(int httpCode, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.httpCode = httpCode;
        this.error = error;
        this.message = message;

    }
}
