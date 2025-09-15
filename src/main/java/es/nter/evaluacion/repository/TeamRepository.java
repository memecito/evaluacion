package es.nter.evaluacion.repository;

import es.nter.evaluacion.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
