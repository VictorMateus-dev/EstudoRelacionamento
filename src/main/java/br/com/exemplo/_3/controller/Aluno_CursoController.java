package br.com.exemplo._3.controller;

import br.com.exemplo._3.model.Alunos_cursos;
import br.com.exemplo._3.service.Alunos_CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno-Curso")
@RequiredArgsConstructor
public class Aluno_CursoController {

    private final Alunos_CursoService alunosCursoService;

    @GetMapping
    public List<Alunos_cursos> listar(){
        return alunosCursoService.listar();
    }


}
