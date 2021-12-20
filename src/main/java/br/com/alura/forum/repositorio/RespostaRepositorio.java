package br.com.alura.forum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Resposta;

public interface RespostaRepositorio extends JpaRepository<Resposta, Long> {

}
	