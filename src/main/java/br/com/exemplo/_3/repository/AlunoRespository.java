package br.com.exemplo._3.repository;

import br.com.exemplo._3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRespository extends JpaRepository<Aluno,Long> {
}
