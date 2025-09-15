package es.nter.evaluacion.application.services;

import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.domain.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeam();

    Team getTeamById(Long id);

    Team createTeam(Team team);

    Team addPlayerToTeam(Long id, Player player);

    Team updateTeam(Long id, Team team);

    boolean deleteTeam(Long id);

    boolean exist(Long id);
}
