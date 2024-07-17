package br.com.alura.forumhub.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "topico")
@Data
public class Topico {

	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "mensagem")
	private String mensagem;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao")
	private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_curso")
	private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
	private Usuario usuario;
    

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY, cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Resposta> respostas;
    
    
}
