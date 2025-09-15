package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.TeamServiceImpl;
import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDtoMini;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    @Transactional
    public ResponseEntity<TeamOuputDto> created(@Valid @RequestBody TeamInputDto teamInputDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(teamMapper.toDto(teamService.createTeam(teamMapper.toModel(teamInputDto))));
    }

    /*
    Añadimos una lista de jugadores al equipo
     */
    @PostMapping("/{id}/player")
    @Transactional
    public ResponseEntity<TeamOuputDto> addPlayerToTeam(@PathVariable Long id, @Valid @RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(
                teamService.addPlayerToTeam(id, playerMapper.toModel((PlayerInputDto) playerInputDto))));
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
