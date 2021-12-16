package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositorio.CursoRepositorio;

public class TopicoForm {

	@NotNull @NotBlank @Length(min = 3, max = 30)
	private String titulo;
	
	@NotNull @NotBlank @Length(min = 10)
	private String mensagem;
	@NotNull @NotBlank
	private String nomeCurso;
	

	public TopicoForm(String titulo, String mensagem, String nomeCurso) {
		
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.nomeCurso = nomeCurso;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getNomeCurso() {
		return nomeCurso;
	}


	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}


	public Topico converter(CursoRepositorio cursoRepositorio) {
		Curso curso = cursoRepositorio.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
	
	
	
	
	
	
}
