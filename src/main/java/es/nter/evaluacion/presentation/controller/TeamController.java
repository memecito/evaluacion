package es.nter.evaluacion.presentation.controller;

import es.nter.evaluacion.presentation.dto.equipos.TeamInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    @GetMapping
    public ResponseEntity<?> getAll(){
        //todo
        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        //todo

        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @PostMapping
    public ResponseEntity<?> created(@RequestBody TeamInputDto teamInputDto){
        //todo

        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TeamInputDto teamInputDto){
        //todo

        return ResponseEntity.ok("funciona, pero esta vacio");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleted(@PathVariable Long id){
        //todo

        return ResponseEntity.ok("funciona, pero esta vacio");
    }
}
