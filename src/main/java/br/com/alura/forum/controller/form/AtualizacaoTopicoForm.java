package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositorio.TopicoRepositorio;

public class AtualizacaoTopicoForm {

	@NotNull @NotBlank @Length(min = 3, max = 30)
	private String titulo;
	
	@NotNull @NotBlank @Length(min = 10)
	private String mensagem;

	
	
	
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

	public Topico atualizar(Long id, TopicoRepositorio topicoRepositorio) {
		Topico topico = topicoRepositorio.getOne(id);
		
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		
		return topico;
	}
	
	
	
}
