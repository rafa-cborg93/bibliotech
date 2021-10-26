package br.com.cborges.bibliotech.controller.dto;

import br.com.cborges.bibliotech.modelo.Usuario;

public class DetalheDoUsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public DetalheDoUsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	
	
}
