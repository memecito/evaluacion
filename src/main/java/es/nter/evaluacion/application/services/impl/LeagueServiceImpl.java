package es.nter.evaluacion.application.services.impl;

import es.nter.evaluacion.application.mappers.LeagueMapper;
import es.nter.evaluacion.application.services.LeagueService;
import es.nter.evaluacion.application.services.TeamService;
import es.nter.evaluacion.domain.entity.League;
import es.nter.evaluacion.domain.entity.Team;
import es.nter.evaluacion.execption.NotFounException;
import es.nter.evaluacion.execption.UnprocesableEntityException;
import es.nter.evaluacion.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;

    private final TeamService teamService;

    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @Override
    public League getLeagueById(Long id) {
        return leagueRepository.findById(id).orElseThrow(
                () -> new NotFounException("Liga con id: " + id + " no encontrada")
        );
    }

    @Override
    public League getLeagueByName(String name) {
        return leagueRepository.findLeagueByName(name).orElseThrow(
                () -> new NotFounException("Liga con nombre: " + name + " no encontrada")
        );
    }

    @Override
    public League createLeague(League league) {
        if (leagueRepository.findLeagueByName(league.getName()).isPresent()) {
            throw new UnprocesableEntityException("Esta liga ya existe");
        }
        return leagueRepository.save(league);
    }

    @Override
    public League addTeam(Long id, Team team) {
        League league = getLeagueById(id);
        Team team1 = teamService.getTeamById(team.getId());
        team1.setLeague(getLeagueById(id));
        Set<Team> teams = league.getTeams();
        teams.add(team1);
        league.setTeams(teams);
        return league;
    }


    @Override
    public League updateLeague(Long id, League league) {
        League leagueOld = getLeagueById(id);
        return leagueMapper.update(leagueOld, league);
    }

    @Override
    public League activedLeague(Long id) {
        League league = getLeagueById(id);
        league.setActive(true);
        return leagueRepository.save(league);

    }


    @Override
    public void deletePlayer(Long id) {
        League league = getLeagueById(id);
        if (!league.getTeams().isEmpty()) {
            throw new UnprocesableEntityException("Esta liga tiene equipo y no se puede eliminar");
        }
        leagueRepository.deleteById(id);
    }
}
