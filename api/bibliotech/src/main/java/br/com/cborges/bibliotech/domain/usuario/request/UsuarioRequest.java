package br.com.cborges.bibliotech.domain.usuario.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioRequest {

	@NotNull @NotEmpty @Length(min = 10)
	private String nome;
	@NotNull @NotEmpty 
	private String email;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;
	@NotNull @NotEmpty
	private String perfil;

}
