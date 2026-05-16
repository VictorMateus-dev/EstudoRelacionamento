package br.com.exemplo._3.service;

import br.com.exemplo._3.model.Aluno;
import br.com.exemplo._3.repository.AlunoRespository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRespository alunoRespository;

    public List<Aluno> list(){
        return alunoRespository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRespository.findById(id)
                .orElseThrow(()->new RuntimeException("Aluno não encontrado"));
    }

    public void delete(Long id){
        alunoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        alunoRespository.deleteById(id);
    }

    public Aluno cadastrar(Aluno aluno){
        return alunoRespository.save(aluno);
    }
}
