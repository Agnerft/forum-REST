package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.RespostaDto;
import br.com.alura.forum.controller.dto.TopicoDetalhadoDto;
import br.com.alura.forum.controller.form.TopicoRespostaForm;
import br.com.alura.forum.modelo.Resposta;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositorio.RespostaRepositorio;
import br.com.alura.forum.repositorio.TopicoRepositorio;

@RestController
public class RespostaControle {

	@Autowired
	private RespostaRepositorio respostaRepositorio;
	
	@Autowired
	private TopicoRepositorio topicoRepositorio;
	
	@RequestMapping("/respostas")
	public List<RespostaDto> listaResposta(){
		
		List<Resposta> respostas = respostaRepositorio.findAll();
		//return RespostaDto.converter(respostas);
                return null;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TopicoDetalhadoDto> responder(Long id, TopicoRespostaForm respostaTopico){
		
		Topico topico = respostaTopico.atualizar(id, topicoRepositorio);
		
		return ResponseEntity.ok(new TopicoDetalhadoDto(topico));
	}
		
	
	
}
