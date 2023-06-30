package br.com.cborges.bibliotech.domain.acervo.response;

import br.com.cborges.bibliotech.entity.Acervo;
import lombok.Data;

@Data
public class AcervoResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private String assunto;
    private Integer qtd;
    private Integer ano;

    public AcervoResponse(Acervo acervo) {
        this.id = acervo.getId();
        this.titulo = acervo.getTitulo();
        this.autor = acervo.getAutor();
        this.editora = acervo.getEditora();
        this.assunto = acervo.getAssunto();
        this.qtd = acervo.getQtd();
        this.ano = acervo.getAno();
    }
}
