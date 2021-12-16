package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repositorio.UsuarioRepositorio;

@RestController
public class UsuariosControle {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@RequestMapping("/usuarios")
	public List<UsuarioDto> listaUsuario(){
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		return UsuarioDto.converter(usuarios);
	}
	
	
}
