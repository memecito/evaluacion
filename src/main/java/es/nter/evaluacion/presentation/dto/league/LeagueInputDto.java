package es.nter.evaluacion.presentation.dto.league;

import es.nter.evaluacion.presentation.dto.teams.TeamInputDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LeagueInputDto {
    @NotBlank(message = "Campo name requerido")
    private String name;
    private String description;
    private boolean active;

    //private List<TeamInputDto> teams;

}
