package br.com.cborges.bibliotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cborges.bibliotech.modelo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	List<Emprestimo> findByAcervoTitulo(String acervoTitulo);

}
