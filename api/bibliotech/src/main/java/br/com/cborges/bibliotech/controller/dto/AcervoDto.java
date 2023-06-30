package br.com.cborges.bibliotech.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cborges.bibliotech.entity.Acervo;

public class AcervoDto {

	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String assunto;
	private Integer qtd;
	private Integer ano;
	
	public AcervoDto(Acervo acervo) {
		this.id = acervo.getId();
		this.titulo = acervo.getTitulo();
		this.autor = acervo.getAutor();
		this.editora = acervo.getEditora();
		this.assunto = acervo.getAssunto();
		this.qtd = acervo.getQtd();
		this.ano = acervo.getAno();
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

	public Integer getQtd() {
		return qtd;
	}

	public Integer getAno() {
		return ano;
	}
	
	public static List<AcervoDto> converter(List<Acervo> acervos){
		return acervos.stream().map(AcervoDto::new).collect(Collectors.toList());
	}
}
