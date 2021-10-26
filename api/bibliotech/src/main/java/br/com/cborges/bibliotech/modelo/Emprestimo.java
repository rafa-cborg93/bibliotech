package br.com.cborges.bibliotech.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Emprestimo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer qtd;
	private LocalDateTime dataEmprestimo = LocalDateTime.now();
	private LocalDateTime dataDevolucao  = dataEmprestimo.plusDays(10);


	@ManyToOne
	private Acervo acervo;
	

	@ManyToOne
	private Usuario cliente;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Emprestimo() {}

	public Emprestimo(Acervo acervo, Integer qtd,
			Usuario cliente) {
		super();
		this.acervo = acervo;
		this.qtd = qtd;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	
	
}
