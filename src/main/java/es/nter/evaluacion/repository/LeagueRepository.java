package es.nter.evaluacion.repository;

import es.nter.evaluacion.domain.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, Long> {
    Optional<League> findLeagueByName(String name);
}
