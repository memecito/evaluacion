package es.nter.evaluacion.application.services.impl;

import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.PlayerService;
import es.nter.evaluacion.application.services.TeamService;
import es.nter.evaluacion.domain.entity.League;
import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.domain.entity.Team;
import es.nter.evaluacion.execption.NotFounException;
import es.nter.evaluacion.execption.UnprocesableEntityException;
import es.nter.evaluacion.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    private final PlayerService playerService;

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new NotFounException("Equipo con id: " + id + " no encontrado")
        );
    }

    @Override
    @Transactional
    public Team createTeam(Team team) {
        if (teamRepository.findTeamByName(team.getName()).isPresent()) {
            throw new UnprocesableEntityException("El quipo ya existe");
        }
        return teamRepository.save(team);
    }

    @Override
    @Transactional
    public Team addPlayerToTeam(Long id, Player players) {

        Team team = getTeamById(id);
        if (Objects.equals(players.getTeam(), team)) {
            playerService.addTeamToPlayer(players.getId(), team);
        }
        return team;
    }

    @Override
    @Transactional
    public Team addLeagueToTeam(Long id, League league) {
        Team team = getTeamById(id);
        team.setLeague(league);
        return teamRepository.save(team);
    }

    @Override
    @Transactional
    public Team updateTeam(Long id, Team team) {
        Team teamOld = getTeamById(id);
        if (Objects.equals(teamOld, team)) {
            throw new UnprocesableEntityException("Error con la entidad actualizable, es la misma");
        }
        return teamMapper.update(teamOld, team);
    }

    @Override
    @Transactional
    public void deleteTeam(Long id) {
        //No es falta de consistencia en la logica, es otra forma de hacerlo difernete a Player
        if (!getTeamById(id).getPlayers().isEmpty()) {
            throw new UnprocesableEntityException("Equipo con jugadores, dele la carta de libertad");
        }
        teamRepository.delete(getTeamById(id));
    }

    @Override
    public boolean exist(Long id) {
        return teamRepository.findById(id).isPresent();
    }

}
