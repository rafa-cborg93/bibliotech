package br.com.cborges.bibliotech.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.cborges.bibliotech.modelo.Usuario;
import br.com.cborges.bibliotech.repository.UsuarioRepository;

public class UsuarioForm {

	@NotNull @NotEmpty @Length(min = 10)
	private String nome;
	@NotNull @NotEmpty 
	private String email;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;
	@NotNull @NotEmpty
	private String perfil;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public Usuario converter(UsuarioRepository usuarioRepository) {
		return new Usuario(nome, email, senha);
	}
}
