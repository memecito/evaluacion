package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.mappers.TeamMapper;
import es.nter.evaluacion.application.services.impl.PlayerServiceImpl;
import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerOuputDto;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerOuputDtoMini;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerServiceImpl playerService;
    private final PlayerMapper playerMapper;

    private final TeamMapper teamMapper;

    @GetMapping
    public ResponseEntity<List<PlayerOuputDtoMini>> getAll() {
        return ResponseEntity.ok(playerService.getAllPlayer().stream().map(playerMapper::toDtoMini)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerOuputDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                playerMapper.toDto(playerService.getPlayerById(id)));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PlayerOuputDto> created(@Valid @RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerMapper.toDto(playerService.createPlayer(playerMapper.toModel(playerInputDto))));
    }

    /*
    Con este endpoint añadimos un equipo al jugador
     */
    @PostMapping("/{id}/team")
    @Transactional
    public ResponseEntity<PlayerOuputDto> addTeamToDto(@PathVariable Long id, @Valid @RequestBody TeamInputDto teamInputDto) {
        return ResponseEntity.ok(playerMapper.toDto(playerService.addTeamToPlayer(id, teamMapper.toModel(teamInputDto))));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlayerOuputDto> update(@PathVariable Long id, @RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.ok(playerMapper.toDto(
                playerService.updatePlayer(id, playerMapper.toModel(playerInputDto))));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleted(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jugador eliminado");

    }


}
