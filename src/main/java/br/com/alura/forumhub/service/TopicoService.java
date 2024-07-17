package br.com.alura.forumhub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.forumhub.dto.TopicoDTO;
import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.CursoRepository;
import br.com.alura.forumhub.repository.TopicoRepository;

@Service
public class TopicoService {

	
	@Autowired
	private TopicoRepository topicoRepository;
	
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	public TopicoDTO novoTopico(TopicoDTO topicoDTO) {
		
		Topico topico = new Topico();
		Usuario usuario= jwtUserDetailsService.getUsuarioAtual();
		Curso curso = cursoRepository.findByNome(topicoDTO.getCurso());
		if(curso != null) {
			topico.setCurso(curso);
		}

		topico.setTitulo(topicoDTO.getTitulo());
		topico.setMensagem(topicoDTO.getMensagem());
		topico.setDataCriacao(new Date());
		topico.setUsuario(usuario);
		topicoRepository.save(topico);
		
		return toDTO(topico);
	}
	
	public TopicoDTO atualizarTopico(TopicoDTO topicoDTO) {
		
		Topico topico = topicoRepository.getById(topicoDTO.getId());
		if (topico != null) {
			topico.setTitulo(topicoDTO.getTitulo());
			topico.setMensagem(topicoDTO.getMensagem());
			topicoRepository.save(topico);
		}
		
		return toDTO(topico);
	}

	public List<TopicoDTO> findAll() {

		List<Topico> topicos = topicoRepository.findAll();
		List<TopicoDTO> retorno = new ArrayList<TopicoDTO>();
		for(Topico topico :  topicos) {
			retorno.add(toDTO(topico));
		}
		return retorno;
	}

	
	private TopicoDTO toDTO(Topico topico) {
		return TopicoDTO.builder()
				.id(topico.getId())
				.curso(topico.getCurso()!= null ? topico.getCurso().getNome() : "")
				.titulo(topico.getTitulo())
				.mensagem(topico.getMensagem())
				.dataCriacao(topico.getDataCriacao())
				.build();
	}

	public TopicoDTO findById(Long idTopico) {
		
		Topico topico = topicoRepository.findById(idTopico).orElse(null);
		if (topico != null) {
			return toDTO(topico);
		}
		return new TopicoDTO();
	}

	public TopicoDTO delete(Long idTopico) {

		Topico topico = topicoRepository.findById(idTopico).orElse(null);
		if (topico != null) {
			topicoRepository.delete(topico);
		}
		return new TopicoDTO();
	}
	 
	
	
	
	
}
