package br.com.alura.forumhub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
import lombok.Data;

@Entity
@Table(name = "perfil")
@Data
public class Perfil {

	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;
}
