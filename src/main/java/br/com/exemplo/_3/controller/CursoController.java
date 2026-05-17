package br.com.exemplo._3.controller;

import br.com.exemplo._3.model.Cursos;
import br.com.exemplo._3.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Cursos> listar(){
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> findById(@PathVariable Long id){
        return cursoService.findById(id)
                .map(curso ->ResponseEntity.ok(curso))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cursoService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cursos cadastrar(@RequestBody Cursos curso){
        return cursoService.cadastrarCursos(curso);
    }
}
