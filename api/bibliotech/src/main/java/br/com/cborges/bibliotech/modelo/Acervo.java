package br.com.cborges.bibliotech.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Acervo {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String assunto;
	private Integer ano;
	private Integer qtd;
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	
	
	@ManyToOne
	private Usuario usu_cadastro;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Acervo() {
		
	}
	public Acervo(String titulo, String autor, String editora, String assunto, Integer ano, Integer qtd, Usuario cliente) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.assunto = assunto;
		this.ano = ano;
		this.qtd = qtd;
		this.usu_cadastro = cliente;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acervo other = (Acervo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Usuario getUsu_cadastro() {
		return usu_cadastro;
	}

	public void setUsu_cadastro(Usuario usu_cadastro) {
		this.usu_cadastro = usu_cadastro;
	}
}
