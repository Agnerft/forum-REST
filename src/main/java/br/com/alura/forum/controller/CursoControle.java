package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repositorio.CursoRepositorio;

@RestController
public class CursoControle {

	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@RequestMapping("/cursos")
	public List<CursoDto> listaCurso(){
		
		List<Curso> cursos = cursoRepositorio.findAll();
		return CursoDto.converter(cursos);
		
		

		
	}
	
}
