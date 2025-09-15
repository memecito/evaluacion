package es.nter.evaluacion.presentation.dto.jugadores;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PlayerOuputDtoMini {

    private Long id;
    private String name;
    private int age;
    private List<String> positions;

}
