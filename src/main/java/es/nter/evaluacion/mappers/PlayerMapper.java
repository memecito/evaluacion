package es.nter.evaluacion.mappers;

import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerOuputDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    //INPUT
    Player toModel(PlayerInputDto playerInputDto);
    //OUPUT
    PlayerInputDto toDto(Player player);
    PlayerOuputDtoMini toDtoMini(Player player);
    //UPDATE
    Player update(@MappingTarget Player target, Player source);
}
