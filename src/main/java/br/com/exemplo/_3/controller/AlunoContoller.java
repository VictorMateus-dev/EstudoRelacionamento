package br.com.exemplo._3.controller;

import br.com.exemplo._3.model.Aluno;
import br.com.exemplo._3.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoContoller {

    private final AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.list();
    }

    @GetMapping("/{id}")
    public Aluno buscarById(@PathVariable Long id){
        return alunoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunoService.delete(id);
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno){
        return alunoService.cadastrar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long id){
        return alunoService.atualizar(aluno, id);
    }

}
