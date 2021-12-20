package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Usuario;

public class UsuarioForm {

	
	@NotNull @NotBlank
	String email;
	@NotNull @NotBlank
	String senha;
	

	public UsuarioForm(String email, String senha) {
		
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario converter() {
		
		//return new Usuario(email, senha);
                return null;
	}
	
	
}
