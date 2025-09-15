package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.application.mappers.PlayerMapper;
import es.nter.evaluacion.application.services.impl.PlayerServiceImpl;
import es.nter.evaluacion.domain.entity.Player;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import es.nter.evaluacion.presentation.dto.jugadores.PlayerOuputDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerServiceImpl playerService;
    private final PlayerMapper playerMapper;

    @GetMapping
    public ResponseEntity<List<PlayerOuputDto>> getAll() {
        return ResponseEntity.ok(playerService.getAllPlayer().stream().map(playerMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerOuputDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                playerMapper.toDto(playerService.getPlayerById(id)));
    }

    @PostMapping
    public ResponseEntity<PlayerOuputDto> created(@RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.ok(playerMapper.toDto(playerService.createPlayer(playerMapper.toModel(playerInputDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerOuputDto> update(@PathVariable Long id, @RequestBody PlayerInputDto playerInputDto) {
        return ResponseEntity.ok(playerMapper.toDto(
                playerService.updatePlayer(id, playerMapper.toModel(playerInputDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleted(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jugador eliminado");

    }


}
