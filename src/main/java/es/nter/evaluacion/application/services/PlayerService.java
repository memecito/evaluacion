package es.nter.evaluacion.application.services;

import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.domain.entity.Team;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayer();

    Player getPlayerById(Long id);

    Player getPlayerByName(String name);

    Player createPlayer(Player player);

    Player addTeamToPlayer(Long id, Team team);

    void cartaLibertad(Long id);

    Player updatePlayer(Long id, Player player);

    boolean deletePlayer(Long id);

}
