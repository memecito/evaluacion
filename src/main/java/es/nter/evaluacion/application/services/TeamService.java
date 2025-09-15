package es.nter.evaluacion.application.services;

import es.nter.evaluacion.domain.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeam();
    Team getTeamById(Long id);
    Team createTeam(Team team);
    Team updateTeam(Long id, Team team);
    boolean deleteTeam(Long id);
}
