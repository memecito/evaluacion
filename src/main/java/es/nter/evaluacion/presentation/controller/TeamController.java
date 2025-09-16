package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.LeagueMapper;
import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.TeamServiceImpl;
import es.nter.evaluacion.presentation.dto.league.LeagueInputDto;
import es.nter.evaluacion.presentation.dto.teams.TeamInputDto;
import es.nter.evaluacion.presentation.dto.teams.TeamOuputDto;
import es.nter.evaluacion.presentation.dto.teams.TeamOuputDtoMini;
import es.nter.evaluacion.presentation.dto.players.PlayerInputDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamServiceImpl teamService;
    private final TeamMapper teamMapper;

    private final PlayerMapper playerMapper;
    private final LeagueMapper leagueMapper;

    @GetMapping
    public ResponseEntity<List<TeamOuputDtoMini>> getAll() {
        return ResponseEntity.ok(teamService.getAllTeam().stream().map(teamMapper::toDtoMini).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamOuputDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                teamMapper.toDto(teamService.getTeamById(id)));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TeamOuputDtoMini> created(@Valid @RequestBody TeamInputDto teamInputDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(teamMapper.toDtoMini(teamService.createTeam(teamMapper.toModel(teamInputDto))));
    }

    @PostMapping("/{id}/player")
    @Transactional
    public ResponseEntity<TeamOuputDto> addPlayerToTeam(@PathVariable Long id,
                                                        @Valid @RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(
                teamService.addPlayerToTeam(id, playerMapper.toModel(playerInputDto))));
    }

    @PostMapping("/{id}/leage")
    @Transactional
    public ResponseEntity<TeamOuputDto> addLeageToTeam(@PathVariable Long id,
                                                       @Valid @RequestBody LeagueInputDto leagueInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(
                teamService.addLeagueToTeam(id, leagueMapper.toModel(leagueInputDto))));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TeamOuputDto> update(@PathVariable Long id, @Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(teamService.updateTeam(id, teamMapper.toModel(teamInputDto))));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleted(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Equipo eliminado");
    }

}
