package br.com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.forumhub.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomoCurso);

}
