package es.nter.evaluacion.presentation.dto.teams;

import es.nter.evaluacion.presentation.dto.league.LeagueOuputDtoMini;
import es.nter.evaluacion.presentation.dto.players.PlayerOuputDtoMini;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamOuputDto {
    private Long id;
    private String name;

    private LeagueOuputDtoMini league;

    private List<PlayerOuputDtoMini> players;


}
