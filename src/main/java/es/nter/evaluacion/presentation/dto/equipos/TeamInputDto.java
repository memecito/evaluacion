package es.nter.evaluacion.presentation.dto.equipos;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamInputDto {

    private Long id;
    @NotBlank
    private String name;

}
