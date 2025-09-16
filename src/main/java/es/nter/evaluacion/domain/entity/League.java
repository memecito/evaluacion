package es.nter.evaluacion.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
    private Long id;
    @Column(name = "name",unique = true, nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status", columnDefinition = "boolean default false")
    private boolean active;

    @OneToMany(mappedBy = "league")
    private List<Team> teams;
}
