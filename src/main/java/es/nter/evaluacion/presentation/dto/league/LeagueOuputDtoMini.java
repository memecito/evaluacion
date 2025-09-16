package es.nter.evaluacion.presentation.dto.league;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeagueOuputDtoMini {
    private Long id;
    private String name;
    private String description;
    private boolean active;
}
