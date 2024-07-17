package br.com.alura.forumhub.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {
 
 
	private static final long serialVersionUID = 2000056692344491329L;
	
	private String username;
    private String password;
    
    

}
