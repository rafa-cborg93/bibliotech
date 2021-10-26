package br.com.cborges.bibliotech.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cborges.bibliotech.modelo.Emprestimo;

public class EmprestimoDto {

	private Long id;
	private Integer qtd;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	
	public EmprestimoDto(Emprestimo emprestimo) {
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
	
	public static List<EmprestimoDto> converter(List<Emprestimo> emprestimos){
		return emprestimos.stream().map(EmprestimoDto:: new).collect(Collectors.toList());
	}
		
}
