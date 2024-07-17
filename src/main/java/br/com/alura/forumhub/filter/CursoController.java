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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumhub.dto.CursoDTO;
import br.com.alura.forumhub.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping()
	public @ResponseBody List<CursoDTO> listarTodos() {
		
		return cursoService.findAll();
	}
	
	@GetMapping("{idCurso}")
	public @ResponseBody CursoDTO recuperarCurso(@PathVariable Long idCurso) {
		
		return cursoService.findById(idCurso);
	}
	@PostMapping
	public @ResponseBody CursoDTO novoCurso(@RequestBody CursoDTO cursoDTO) {
		
		return cursoService.save(cursoDTO);
	}
	
	@PutMapping
	public @ResponseBody CursoDTO atualizar(@RequestBody CursoDTO cursoDTO) {
		
		return cursoService.update(cursoDTO);
	}

	@DeleteMapping("{idCurso}")
	public @ResponseBody CursoDTO delete(@PathVariable Long idCurso) {
		
		return cursoService.delete(idCurso);
	}
}
