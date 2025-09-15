package es.nter.evaluacion.presentation.dto.equipos;

import es.nter.evaluacion.domain.entity.Player;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TeamInputDto {

    private Long id_equipo;
    @NotBlank
    private String nombre_equipo;

    private List<Player> jugadores;
}
