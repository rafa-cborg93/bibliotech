package br.com.cborges.bibliotech.domain.emprestimo.request;

import br.com.cborges.bibliotech.entity.Acervo;
import br.com.cborges.bibliotech.entity.Usuario;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EmprestimoRequest {

	@NotNull 
	private Integer qtd;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	private Acervo acervo;
	private Usuario usuario;

}
