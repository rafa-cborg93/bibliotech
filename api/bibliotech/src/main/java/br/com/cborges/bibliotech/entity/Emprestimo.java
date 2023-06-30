package br.com.cborges.bibliotech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtd;
    private LocalDateTime dataEmprestimo = LocalDateTime.now();
    private LocalDateTime dataDevolucao = dataEmprestimo.plusDays(10);
    @ManyToOne
    private Acervo acervo;
    @ManyToOne
    private Usuario cliente;

}
