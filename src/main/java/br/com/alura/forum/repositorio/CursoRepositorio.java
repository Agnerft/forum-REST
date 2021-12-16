package br.com.alura.forum.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

	

}
