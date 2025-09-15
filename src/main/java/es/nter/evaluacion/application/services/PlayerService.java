package es.nter.evaluacion.application.services;

import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.domain.entity.Team;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayer();

    Player getPlayerById(Long id);

    Player createPlayer(Player player);

    Player addTeamToPlayer(Long id, Team team);

    Player updatePlayer(Long id, Player player);

    void deletePlayer(Long id);

}
