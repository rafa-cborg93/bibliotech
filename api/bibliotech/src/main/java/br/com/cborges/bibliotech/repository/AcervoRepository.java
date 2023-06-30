package br.com.cborges.bibliotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cborges.bibliotech.entity.Acervo;

public interface AcervoRepository extends JpaRepository<Acervo, Long> {

	List<Acervo> findByTitulo(String titulo);
}
