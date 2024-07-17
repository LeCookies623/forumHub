package br.com.alura.forumhub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.forumhub.dto.CursoDTO;
import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public CursoDTO save(CursoDTO cursoDTO) {
		
		Curso curso = cursoRepository.findByNome(cursoDTO.getNome());
		if (curso == null) {
			curso =  Curso.builder()
					.nome(cursoDTO.getNome())
					.categoria(cursoDTO.getCategoria())
					.build();
		} 
		cursoRepository.save(curso);
		cursoDTO.setId(curso.getId());
		return cursoDTO;
	}
	
	
	
	public CursoDTO update(CursoDTO cursoDTO) {
		
		Curso curso = cursoRepository.findById(cursoDTO.getId()).orElse(null);
		if (curso != null) {
			curso =  Curso.builder()
					.nome(cursoDTO.getNome())
					.categoria(cursoDTO.getCategoria())
					.build();
			cursoRepository.save(curso);
			cursoDTO.setId(curso.getId());
		}
		return cursoDTO;
	}
	
	
	
	public CursoDTO delete(Long idCurso) {

		Curso curso = cursoRepository.getById(idCurso);
		if (curso != null) {
			cursoRepository.delete(curso);
		}
		
		return new CursoDTO();
	}

	public CursoDTO findById(Long idCurso) {
		Curso curso = cursoRepository.findById(idCurso).orElse(null);
		if (curso != null) {
			return toDTO(curso);
		}
		return null;
	}


	public List<CursoDTO> findAll() {
		List<Curso> cursos = cursoRepository.findAll();
		List<CursoDTO> retorno = new ArrayList<CursoDTO>();
		for(Curso curso :  cursos) {
			retorno.add(toDTO(curso));
		}
		return retorno;
	}
	
	private CursoDTO toDTO(Curso curso) {
		return CursoDTO.builder()
				.id(curso.getId())
				.nome(curso.getNome())
				.categoria(curso.getCategoria())
				.build();
	}

}
