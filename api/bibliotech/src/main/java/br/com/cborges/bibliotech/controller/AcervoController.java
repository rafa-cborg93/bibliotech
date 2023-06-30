package br.com.cborges.bibliotech.controller;

import br.com.cborges.bibliotech.domain.acervo.response.AcervoResponse;
import br.com.cborges.bibliotech.domain.acervo.request.AcervoRequest;
import br.com.cborges.bibliotech.domain.acervo.service.AcervoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/acervos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AcervoController {

    private final AcervoService service;

    @GetMapping
    public List<AcervoResponse> lista(String titulo) {
        return service.getAcervos(titulo);
    }

    @PostMapping
    public ResponseEntity<AcervoResponse> cadastrar(@RequestBody @Valid AcervoRequest request, UriComponentsBuilder uriBuilder) {
        return service.createAcervo(request, uriBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcervoResponse> detalhar(@PathVariable Long id) {
        return service.getAcervo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcervoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AcervoRequest request) {
        return service.updateAcervo(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return service.deleteAcervo(id);
    }

}
