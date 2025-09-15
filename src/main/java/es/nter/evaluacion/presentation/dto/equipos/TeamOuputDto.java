package es.nter.evaluacion.presentation.dto.equipos;

import es.nter.evaluacion.domain.entity.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamOuputDto {
    private Long id_equipo;
    private String name;

    private List<Player> jugadores;
}
