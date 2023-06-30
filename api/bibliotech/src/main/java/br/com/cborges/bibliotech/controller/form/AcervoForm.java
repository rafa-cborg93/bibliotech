package br.com.cborges.bibliotech.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.cborges.bibliotech.entity.Acervo;
import br.com.cborges.bibliotech.repository.AcervoRepository;

public class AcervoForm {

	@NotNull @NotEmpty @Length(min = 10)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10)
	private String autor;
	@NotNull @NotEmpty @Length(min = 10)
	private String editora;
	@NotNull @NotEmpty @Length(min = 10)
	private String assunto;
	@NotNull  
	private Integer ano;
	@NotNull 
	private Integer qtd;
	
	private LocalDateTime dataCadastro;
	 
	private String usuario;
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Integer getQtd() {
		return qtd;
	}


	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}


	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Acervo converter(AcervoRepository acervoRepository) {
		return new Acervo(titulo, autor,editora,assunto, ano, qtd,null);
	}

}
