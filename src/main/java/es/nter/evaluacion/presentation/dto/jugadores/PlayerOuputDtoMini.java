package es.nter.evaluacion.presentation.dto.jugadores;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PlayerOuputDtoMini {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private List<String> positions;
}
