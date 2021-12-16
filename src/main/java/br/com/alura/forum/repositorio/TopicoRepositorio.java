package br.com.alura.forum.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;
	
												//Dentro dos Genericos do JpaRepository
												 // < , > no primeiro vai a entidade que esse repositorio vai pegar
												 //   no segundo vai o tipo de atributo do Id da chave primaria da entidade
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {

	List<Topico> findByCurso_Nome(String nomeCurso);

}