package br.com.cborges.bibliotech.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.cborges.bibliotech.modelo.Acervo;
import br.com.cborges.bibliotech.modelo.Emprestimo;
import br.com.cborges.bibliotech.modelo.Usuario;
import br.com.cborges.bibliotech.repository.EmprestimoRepository;

public class EmprestimoForm {

	@NotNull 
	private Integer qtd;
	
	private LocalDateTime dataEmprestimo;
	
	private LocalDateTime dataDevolucao;
	private Acervo acervo;
	private Usuario usuario;
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Emprestimo converter(EmprestimoRepository emprestimoRepository) {
		return new Emprestimo(acervo, qtd, usuario);
		
	}
}
