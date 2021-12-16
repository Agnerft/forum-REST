package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDetalhadoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositorio.CursoRepositorio;
import br.com.alura.forum.repositorio.TopicoRepositorio;

@RestController
@RequestMapping("/topicos")  // PREFIXO do método
public class TopicosControle {

	@Autowired
	private TopicoRepositorio topicoRepositorio;
	@Autowired
	private CursoRepositorio cursoRepositorio;
		
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if(nomeCurso == null) {
		List<Topico> topicos = topicoRepositorio.findAll();
		return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepositorio.findByCurso_Nome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		// @RequestBody -to dizendo que quero pegar a info no corpo da requisição
		Topico topico = form.converter(cursoRepositorio);
		// Quando se cria um metodo POST se executar correto, vem um 200, que quer dizer que esta tudo ok
		// Quando coloco O ResponseEntity<Nomedo da Entidade> ele quer um retorno uri.
		// Deveria passar um http://localhost:8070/topicos/(alguma coisa), mas quando coloco o UriComponentsBuilder
		// Completa a Uri pra mim, só precis passar o uriBuilder.path("/topicos/{id}" ( id entre {} quer dizer que o id é dinamico
		// .path("/topicos/{id}").buildAndExpand(Da onde vou pegar o Id pra injetar no .path).toUri
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		topicoRepositorio.save(topico);
		// retorno o ResponseEntity.created(a uri que eu criei).body(new TopicoDto(topico)) no .body eu passo que a cada new vira
		// esse retorno com o id novo
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public TopicoDetalhadoDto detalhar(@PathVariable Long id) {
		
		Topico topico = topicoRepositorio.getOne(id);
		return new TopicoDetalhadoDto(topico);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Topico topico = form.atualizar(id, topicoRepositorio);
		return ResponseEntity.ok(new TopicoDto(topico));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		topicoRepositorio.deleteById(id);		
		return ResponseEntity.ok().build();
	
	}
	
	
}
