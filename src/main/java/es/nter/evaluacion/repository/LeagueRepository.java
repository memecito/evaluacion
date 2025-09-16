package es.nter.evaluacion.repository;

import es.nter.evaluacion.domain.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {
}
