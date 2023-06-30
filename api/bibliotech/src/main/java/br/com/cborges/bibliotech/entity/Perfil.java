package br.com.cborges.bibliotech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
public class Perfil implements GrantedAuthority {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@Override
	public String getAuthority() {
		return nome;
	}
	
}
