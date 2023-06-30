package br.com.cborges.bibliotech.domain.emprestimo.service;

import br.com.cborges.bibliotech.domain.emprestimo.response.EmprestimoResponse;
import br.com.cborges.bibliotech.domain.emprestimo.request.EmprestimoRequest;
import br.com.cborges.bibliotech.entity.Emprestimo;
import br.com.cborges.bibliotech.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public List<EmprestimoResponse> getEmprestimosList(String acervoTitulo) {
        if (acervoTitulo == null) {
            List<Emprestimo> emprestimos = emprestimoRepository.findAll();
            return convertListToResponseList(emprestimos);
        } else {
            List<Emprestimo> emprestimos = emprestimoRepository.findByAcervoTitulo(acervoTitulo);
            return convertListToResponseList(emprestimos);
        }
    }

    public ResponseEntity<EmprestimoResponse> createEmprestimo(EmprestimoRequest request, UriComponentsBuilder uriBuilder) {
        Emprestimo emprestimo = convertRequestToEntity(request);
        emprestimoRepository.save(emprestimo);

        URI uri = uriBuilder.path("/emprestimos/{id}").buildAndExpand(emprestimo.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmprestimoResponse(emprestimo));
    }

    public ResponseEntity<EmprestimoResponse> getEmprestimo(Long id) {
        Optional<Emprestimo> optional = emprestimoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new EmprestimoResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> deleteEmprestimo(Long id) {
        Optional<Emprestimo> optional = emprestimoRepository.findById(id);
        if (optional.isPresent()) {
            emprestimoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Emprestimo convertRequestToEntity(EmprestimoRequest request) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setQtd(request.getQtd());
        emprestimo.setDataEmprestimo(request.getDataEmprestimo());
        emprestimo.setDataDevolucao(request.getDataDevolucao());
        emprestimo.setAcervo(request.getAcervo());
        emprestimo.setCliente(request.getUsuario());

        return emprestimo;
    }

    private List<EmprestimoResponse> convertListToResponseList(List<Emprestimo> emprestimos) {
        return emprestimos.stream().map(EmprestimoResponse::new).collect(Collectors.toList());
    }
}
