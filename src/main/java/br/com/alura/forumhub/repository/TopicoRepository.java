package br.com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.forumhub.model.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{

	
}
