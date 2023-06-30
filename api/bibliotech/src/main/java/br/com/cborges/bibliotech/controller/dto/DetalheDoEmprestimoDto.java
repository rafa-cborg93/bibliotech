package br.com.cborges.bibliotech.controller.dto;

import java.time.LocalDateTime;

import br.com.cborges.bibliotech.entity.Emprestimo;

public class DetalheDoEmprestimoDto {

	private Long id;
	private Integer qtd;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	
	public DetalheDoEmprestimoDto(Emprestimo emprestimo) {
		this.id = emprestimo.getId();
		this.qtd = emprestimo.getQtd();
		this.dataEmprestimo = emprestimo.getDataEmprestimo();
		this.dataDevolucao = emprestimo.getDataDevolucao();
	}

	public Long getId() {
		return id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	
}
