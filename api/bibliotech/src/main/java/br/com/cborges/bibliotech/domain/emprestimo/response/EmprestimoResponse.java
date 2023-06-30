package br.com.cborges.bibliotech.domain.emprestimo.response;

import br.com.cborges.bibliotech.entity.Emprestimo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmprestimoResponse {

    private Long id;
    private Integer qtd;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public EmprestimoResponse(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.qtd = emprestimo.getQtd();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataDevolucao = emprestimo.getDataDevolucao();
    }
}
