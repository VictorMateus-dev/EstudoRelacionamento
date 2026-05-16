package br.com.exemplo._3.repository;

import br.com.exemplo._3.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Cursos,Long> {
}
