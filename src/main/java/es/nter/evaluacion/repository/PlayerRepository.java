package es.nter.evaluacion.repository;

import es.nter.evaluacion.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
