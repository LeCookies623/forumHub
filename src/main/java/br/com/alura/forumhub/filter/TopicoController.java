package br.com.alura.forumhub.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumhub.dto.TopicoDTO;
import br.com.alura.forumhub.service.TopicoService;

@RestController
@RequestMapping("topicos")
public class TopicoController {

	@Autowired
	private TopicoService topicoService;

	@GetMapping()
	public @ResponseBody List<TopicoDTO> listarTodos() {
		
		return topicoService.findAll();
	}
	
	@GetMapping("{idTopico}")
	public @ResponseBody TopicoDTO recuperarTopico(@PathVariable Long idTopico) {
		
		return topicoService.findById(idTopico);
	}
	@PostMapping
	public @ResponseBody TopicoDTO novoTopico(@RequestBody TopicoDTO TopicoDTO) {
		
		return topicoService.novoTopico(TopicoDTO);
	}
	
	@PutMapping
	public @ResponseBody TopicoDTO atualizar(@RequestBody TopicoDTO TopicoDTO) {
		
		return topicoService.atualizarTopico(TopicoDTO);
	}

	@DeleteMapping("{idTopico}")
	public @ResponseBody TopicoDTO delete(@PathVariable Long idTopico) {
		
		return topicoService.delete(idTopico);
	}
}
