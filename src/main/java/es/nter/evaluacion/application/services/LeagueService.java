package es.nter.evaluacion.application.services;

import es.nter.evaluacion.domain.entity.League;
import es.nter.evaluacion.domain.entity.Team;

import java.util.List;

public interface LeagueService {
    List<League> getAllLeagues();

    League getLeagueById(Long id);

    League getLeagueByName(String name);

    League createLeague(League league);

    League addTeam(Long id, Team model);

    League updateLeague(Long id, League league);

    League activedLeague(Long id);

    void deletePlayer(Long id);

}
