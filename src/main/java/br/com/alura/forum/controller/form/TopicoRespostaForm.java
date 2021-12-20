package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositorio.TopicoRepositorio;

public class TopicoRespostaForm {
	
	private String RespostaTopico;

	public String getRespostaTopico() {
		return RespostaTopico;
	}
	
	public void setRespostaTopico(String respostaTopico) {
		this.RespostaTopico = respostaTopico;
	}

	public Topico atualizar(Long id, TopicoRepositorio topicoRepositorio) {
		Topico topico = topicoRepositorio.getOne(id);
		
		//topico.setRespostas(this.RespostaTopico);
		
		return topico;
	}
	
	
	
}
