package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.TeamServiceImpl;
import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import es.nter.evaluacion.presentation.dto.equipos.TeamOuputDto;
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
    @GetMapping
    public ResponseEntity<List<TeamOuputDto>> getAll() {
        return ResponseEntity.ok(teamService.getAllTeam().stream().map(teamMapper::toDto).collect(Collectors.toList()));
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

    @PutMapping("/{id}")
    public ResponseEntity<TeamOuputDto> update(@PathVariable Long id, @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(teamMapper.toDto(teamService.updateTeam(id,teamMapper.toModel(teamInputDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleted(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Equipo eliminado");
    }
}
