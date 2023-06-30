package br.com.cborges.bibliotech.domain.usuario.response;

import br.com.cborges.bibliotech.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioResponse {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getEmail();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
}
