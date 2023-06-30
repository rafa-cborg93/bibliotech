package br.com.cborges.bibliotech.controller;

import br.com.cborges.bibliotech.domain.emprestimo.response.EmprestimoResponse;
import br.com.cborges.bibliotech.domain.emprestimo.request.EmprestimoRequest;
import br.com.cborges.bibliotech.domain.emprestimo.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService service;

    @GetMapping
    public List<EmprestimoResponse> lista(String acervoTitulo) {
        return service.getEmprestimosList(acervoTitulo);
    }

    @PostMapping
    public ResponseEntity<EmprestimoResponse> cadastrar(@RequestBody @Valid EmprestimoRequest request, UriComponentsBuilder uriBuilder) {
        return service.createEmprestimo(request, uriBuilder);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmprestimoResponse> detalhar(@PathVariable Long id) {
        return service.getEmprestimo(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
     return service.deleteEmprestimo(id);
    }
}
