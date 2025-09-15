package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.presentation.dto.jugadores.PlayerInputDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @PostMapping
    public ResponseEntity<?> created(@RequestBody PlayerInputDto playerInputDto){
        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PlayerInputDto playerInputDto){
        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleted(@PathVariable Long id){
        return ResponseEntity.ok("funciona, pero esta vacio");
    }


}
