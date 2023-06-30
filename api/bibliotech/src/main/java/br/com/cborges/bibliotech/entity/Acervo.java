package br.com.cborges.bibliotech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acervo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
