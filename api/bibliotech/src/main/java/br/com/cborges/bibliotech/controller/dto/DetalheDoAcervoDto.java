package br.com.cborges.bibliotech.controller.dto;

import br.com.cborges.bibliotech.modelo.Acervo;

public class DetalheDoAcervoDto {
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String assunto;
	private Integer ano;
	private Integer qtd;
	
	public DetalheDoAcervoDto(Acervo acervo) {
		this.id = acervo.getId();
		this.titulo = acervo.getTitulo();
		this.autor = acervo.getAutor();
		this.editora = acervo.getEditora();
		this.assunto = acervo.getAssunto();
		this.ano = acervo.getAno();
		this.qtd = acervo.getQtd();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditora() {
		return editora;
	}

	public String getAssunto() {
		return assunto;
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getQtd() {
		return qtd;
	}
	
	
}
