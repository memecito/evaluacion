package es.nter.evaluacion.presentation.dto;

import lombok.Builder;

@Builder
public record ReturnMessage(
        int status,
        String message) {
}
