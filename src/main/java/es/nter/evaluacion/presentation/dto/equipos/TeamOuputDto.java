package es.nter.evaluacion.presentation.dto.equipos;

import es.nter.evaluacion.presentation.dto.jugadores.PlayerOuputDtoMini;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamOuputDto {
    private Long id;
    private String name;

    private List<PlayerOuputDtoMini> players;
}
