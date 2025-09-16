package es.nter.evaluacion.application.mappers;

import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.presentation.dto.players.PlayerInputDto;
import es.nter.evaluacion.presentation.dto.players.PlayerOuputDto;
import es.nter.evaluacion.presentation.dto.players.PlayerOuputDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    //INPUT
    Player toModel(PlayerInputDto playerInputDto);

    //OUPUT
    PlayerOuputDto toDto(Player player);

    PlayerOuputDtoMini toDtoMini(Player player);

    //UPDATE
    Player update(@MappingTarget Player target, Player source);
}
