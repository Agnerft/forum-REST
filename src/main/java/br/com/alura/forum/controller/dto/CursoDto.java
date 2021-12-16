package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Curso;

public class CursoDto {

	private String nome;
	private String categoria;
	
	
	public CursoDto(Curso curso) {
		this.nome = curso.getNome();
		this.categoria = curso.getCategoria();
	}


	public String getNome() {
		return nome;
	}


	public String getCategoria() {
		return categoria;
	}


	public static List<CursoDto> converter(List<Curso> cursos) {
		
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
	}

	
	
	
}
