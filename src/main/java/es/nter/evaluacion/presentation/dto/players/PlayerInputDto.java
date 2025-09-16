package es.nter.evaluacion.presentation.dto.players;

import es.nter.evaluacion.presentation.dto.teams.TeamInputDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerInputDto {

    private Long id;
    @NotBlank(message = "Campo Name requerido")
    private String name;
    @NotBlank(message = "Campo Surname requerido")
    private String surname;
    @Min(value = 0, message = "debe introducir una edad validad")
    @Max(value = 99, message = "debe introducir una edad validad")
    private int age;
    //TODO falta pedir la @
    @NotBlank(message = "Campo EMAIL requerido")
    @Email(message = "formato email no valido")
    private String email;
    private List<String> positions;

    private TeamInputDto team;
}
