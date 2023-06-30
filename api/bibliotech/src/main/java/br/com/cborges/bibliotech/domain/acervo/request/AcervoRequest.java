package br.com.cborges.bibliotech.domain.acervo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AcervoRequest {

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String autor;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String editora;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String assunto;
    @NotNull
    private Integer ano;
    @NotNull
    private Integer qtd;
    private LocalDateTime dataCadastro;
    private String usuario;

}
