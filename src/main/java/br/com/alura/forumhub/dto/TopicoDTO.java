package br.com.alura.forumhub.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicoDTO {

	private Long id;
	
	private String mensagem;
	
	private String curso;
	
	private String titulo;
	
	private Date dataCriacao;
}
