package es.nter.evaluacion.application.services.impl;

import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.TeamService;
import es.nter.evaluacion.domain.entity.Team;
import es.nter.evaluacion.execption.NotFounException;
import es.nter.evaluacion.execption.UnprocesableEntityException;
import es.nter.evaluacion.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                ()-> new NotFounException("Equipo con id: "+id+" no encontrado")
        );
    }

    @Override
    public Team createTeam(Team team) {
        if(!teamRepository.findTeamByName(team.getName()).isEmpty()){
            throw new UnprocesableEntityException("El quipo ya existe");
        }
        return null;
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        Team teamOld= getTeamById(id);
        return teamMapper.update(teamOld, team);
    }

    @Override
    public boolean deleteTeam(Long id) {
        //No es falta de consistencia en la logica, es otra forma de hacerlo difernete a Player
        teamRepository.delete(getTeamById(id));
            return true;
    }
}
