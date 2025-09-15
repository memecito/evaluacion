package es.nter.evaluacion.mappers;

import es.nter.evaluacion.domain.entity.Team;
import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    //INPUT
    Team toModel(TeamInputDto teamInputDto);
    //OUPUT
    TeamOuputDto toDto(Team team);
    TeamOuputDtoMini toDtoMini(Team team);
    //UPDATE

    Team update(@MappingTarget Team target, Team source);

}
