package es.nter.evaluacion.application.mappers;

import es.nter.evaluacion.domain.entity.League;
import es.nter.evaluacion.presentation.dto.league.LeagueInputDto;
import es.nter.evaluacion.presentation.dto.league.LeagueOuputDto;
import es.nter.evaluacion.presentation.dto.league.LeagueOuputDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LeagueMapper {

    //INPUT
    League toModel(LeagueInputDto leagueInputDto);
    //OUPUT

    LeagueOuputDto toDto(League league);

    LeagueOuputDtoMini toDtoMini(League league);

    //UPDATE
    League update(@MappingTarget League target, League source);
}
