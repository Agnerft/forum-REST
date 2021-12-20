package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Usuario;

public class UsuarioDtoCadastro {

	private Long id;
	private String email;
	private String senha;
	
	
	public UsuarioDtoCadastro(Usuario usuario) {

		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	
}


	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getSenha() {
		return senha;
	}
}
