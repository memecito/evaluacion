package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.presentation.dto.league.LeagueInputDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeaguerController {

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("metodo por crear");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok("metodo por crear");
    }

    @PostMapping
    public ResponseEntity<?> created(@Valid @RequestBody LeagueInputDto leagueInputDto){
        return ResponseEntity.ok("metodo por crear");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody LeagueInputDto leagueInputDto){
        return ResponseEntity.ok("metodo por crear");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok("metodo por crear");
    }
}
