package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.TeamServiceImpl;
import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDtoMini;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<TeamOuputDto> created(@Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(
                teamMapper.toDto(teamService.createTeam(teamMapper.toModel(teamInputDto)))
        );
    }
    @PostMapping
    public ResponseEntity<TeamOuputDto> created(@Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(
                teamMapper.toDto(teamService.createTeam(teamMapper.toModel(teamInputDto)))
        );
    }
    @PostMapping("/{id}/player")
    public ResponseEntity<TeamOuputDto> addPlayerToTeam(@PathVariable Long id,@Valid @RequestBody PlayerInputDto playerInputDto){
        return ResponseEntity.ok(teamMapper.toDto(
                teamService.addPlayerToTeam(id,playerMapper.toModel(playerInputDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamOuputDto> update(@PathVariable Long id,@Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(teamService.updateTeam(id,teamMapper.toModel(teamInputDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleted(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Equipo eliminado");
    }
}
