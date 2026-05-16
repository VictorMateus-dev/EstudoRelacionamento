package br.com.exemplo._3.service;

import br.com.exemplo._3.model.Cursos;
import br.com.exemplo._3.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<Cursos> listar(){
        return cursoRepository.findAll();
    }

    public Optional<Cursos> findById(Long id){
        return cursoRepository.findById(id);
    }

    public void delete(Long id){
        cursoRepository.deleteById(id);
    }

    public Cursos cadastrarCursos(Cursos cursos){
        return  cursoRepository.save(cursos);
    }
}
