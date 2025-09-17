package es.nter.evaluacion.presentation.dto.teams;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class TeamInputDto {

    private Long id;
    @NotBlank(message = "hace falta el nombre")
    private String name;

}
