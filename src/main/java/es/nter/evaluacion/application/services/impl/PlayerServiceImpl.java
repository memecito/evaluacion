package es.nter.evaluacion.application.services.impl;

import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.services.PlayerService;
import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.domain.entity.Team;
import es.nter.evaluacion.execption.NotFounException;
import es.nter.evaluacion.execption.UnprocesableEntityException;
import es.nter.evaluacion.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;



    @Override
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new NotFounException("Jugador con id: " + id + " no encontrado")
        );
    }



    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player addTeamToPlayer(Long id, Team team) {

        Player player = getPlayerById(id);
        if(!teamService.exist(team.getId())){
            throw new UnprocesableEntityException("El equipo no existe");
        }
        player.setTeam(team);
        return playerRepository.save(player);
    }


    @Override
    public Player updatePlayer(Long id, Player player) {
        Player playerOld = getPlayerById(id);
        return playerMapper.update(playerOld, player);
    }

    @Override
    public boolean deletePlayer(Long id) {
        if (playerRepository.findById(id).isEmpty()) {
            throw new UnprocesableEntityException("El jugador no se encuentra en la base de datos");
        }
        playerRepository.deleteById(id);
        return true;
    }
}
