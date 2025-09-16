package es.nter.evaluacion.presentation.dto.league;

import es.nter.evaluacion.presentation.dto.teams.TeamInputDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class LeagueOuputDtoMini {
    private Long id;
    private String name;
    private String description;
    private boolean active;

    private List<TeamInputDto> teams;

}
