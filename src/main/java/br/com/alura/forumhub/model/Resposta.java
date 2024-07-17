package br.com.alura.forumhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "resposta")
@Data
public class Resposta {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @JoinColumn(name = "mensagem")
    private String mensagem;
    
    @JoinColumn(name = "solucao")
    private Boolean solucao;

}
