package br.com.exemplo._3.service;

import br.com.exemplo._3.model.Aluno;
import br.com.exemplo._3.model.Alunos_cursos;
import br.com.exemplo._3.model.Cursos;
import br.com.exemplo._3.repository.AlunoRespository;
import br.com.exemplo._3.repository.Alunos_cursosRepository;
import br.com.exemplo._3.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Alunos_CursoService {

    AlunoRespository alunoRespository;
    CursoRepository cursoRepository;
    Alunos_cursosRepository alunosCursosRepository;

    public Alunos_cursos cadastrar(Long curso_Id, Long aluno_Id){
        Aluno aluno = alunoRespository.findById(aluno_Id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Cursos curso = cursoRepository.findById(curso_Id)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado"));

        Alunos_cursos matricula = new Alunos_cursos();

        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        return alunosCursosRepository.save(matricula);
    }

    public List<Alunos_cursos> listar(){
        return alunosCursosRepository.findAll();
    }

    public Optional<Alunos_cursos> buscarById(Long id){
       alunosCursosRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Matricula não encontrada"));
       return alunosCursosRepository.findById(id);
    }

    public void deletar(Long id){
        alunosCursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        alunosCursosRepository.deleteById(id);
    }


}
