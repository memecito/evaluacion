package es.nter.evaluacion.presentation.dto.players;

import es.nter.evaluacion.presentation.dto.teams.TeamOuputDtoMini;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class PlayerOuputDto {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private List<String> positions;

    private TeamOuputDtoMini team;
}
