package br.com.exemplo._3.controller;

import br.com.exemplo._3.model.Alunos_cursos;
import br.com.exemplo._3.service.Alunos_CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno-Curso")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Aluno_CursoController {

    private final Alunos_CursoService alunosCursoService;

    @GetMapping
    public List<Alunos_cursos> listar(){
        return alunosCursoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Alunos_cursos> buscarById(@PathVariable Long id){
        return alunosCursoService.buscarById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunosCursoService.deletar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alunos_cursos cadastrar(@RequestParam Long curso_id,
                                   @RequestParam Long aluno_id){
        return alunosCursoService.cadastrar(curso_id, aluno_id);
    }


}
