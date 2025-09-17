package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.LeagueMapper;
import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.LeagueServiceImpl;
import es.nter.evaluacion.presentation.dto.league.LeagueInputDto;
import es.nter.evaluacion.presentation.dto.league.LeagueOuputDto;
import es.nter.evaluacion.presentation.dto.league.LeagueOuputDtoMini;
import es.nter.evaluacion.presentation.dto.teams.TeamInputDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeaguerController {

    private final LeagueServiceImpl leagueService;
    private final LeagueMapper leagueMapper;

    private final TeamMapper teamMapper;

    @GetMapping
    public ResponseEntity<List<LeagueOuputDtoMini>> getAll() {
        return ResponseEntity.ok(leagueService.getAllLeagues().stream()
                .map(leagueMapper::toDtoMini).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueOuputDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(leagueMapper.toDto(leagueService.getLeagueById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<LeagueOuputDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok(leagueMapper.toDto(leagueService.getLeagueByName(name)));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LeagueOuputDtoMini> created(@Valid @RequestBody LeagueInputDto leagueInputDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leagueMapper.toDtoMini(leagueService.createLeague(leagueMapper.toModel(leagueInputDto))));
    }

    @PostMapping("/{id}/teams")
    public ResponseEntity<LeagueOuputDto> addTeamsToLeage(@PathVariable Long id,
                                                          @Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leagueMapper.toDto(leagueService.addTeam(id, teamMapper.toModel(teamInputDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeagueOuputDto> update(@PathVariable Long id, @Valid @RequestBody LeagueInputDto leagueInputDto) {
        return ResponseEntity.ok(leagueMapper.toDto(
                leagueService.updateLeague(id, leagueMapper.toModel(leagueInputDto))));
    }

    @PutMapping("/{id}/actived")
    public ResponseEntity<LeagueOuputDto> activedLeague(@PathVariable Long id) {
        return ResponseEntity.ok(leagueMapper.toDto(
                leagueService.activedLeague(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        leagueService.deletePlayer(id);

        // todo crear un objeto para mandar el mensaje...
        return ResponseEntity.ok().body("Liga borrada");
    }
}
