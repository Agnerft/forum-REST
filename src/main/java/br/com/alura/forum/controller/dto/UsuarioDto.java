package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Usuario;

public class UsuarioDto {
	
	private String nome;
	private String email;
	
	
	
	public UsuarioDto(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

	
	
}
