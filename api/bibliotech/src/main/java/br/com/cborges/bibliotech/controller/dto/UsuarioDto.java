package br.com.cborges.bibliotech.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cborges.bibliotech.modelo.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getEmail();
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
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDto:: new).collect(Collectors.toList());
	}
}
