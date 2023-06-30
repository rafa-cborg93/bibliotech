package br.com.cborges.bibliotech.domain.acervo.service;

import br.com.cborges.bibliotech.domain.acervo.response.AcervoResponse;
import br.com.cborges.bibliotech.domain.acervo.request.AcervoRequest;
import br.com.cborges.bibliotech.entity.Acervo;
import br.com.cborges.bibliotech.repository.AcervoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcervoService {
    private final AcervoRepository acervoRepository;

    public List<AcervoResponse> getAcervos(String titulo) {
        if (titulo == null) {
            List<Acervo> acervos = acervoRepository.findAll();
            return convertListToResponseList(acervos);
        } else {
            List<Acervo> acervos = acervoRepository.findByTitulo(titulo);
            return convertListToResponseList(acervos);
        }
    }

    public ResponseEntity<AcervoResponse> createAcervo(AcervoRequest request, UriComponentsBuilder uriBuilder) {
        Acervo acervo = convertRequestToEntity(request);
        acervoRepository.save(acervo);

        URI uri = uriBuilder.path("/acervos/{id}").buildAndExpand(acervo.getId()).toUri();
        return ResponseEntity.created(uri).body(new AcervoResponse(acervo));
    }

    public ResponseEntity<AcervoResponse> getAcervo(Long id) {
        Optional<Acervo> optional = acervoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new AcervoResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }



    public ResponseEntity<AcervoResponse> updateAcervo(Long id, @Valid AcervoRequest request) {
        Optional<Acervo> optional = acervoRepository.findById(id);
        if (optional.isPresent()) {
            Acervo acervo = convertRequestToEntity(request);
            return ResponseEntity.ok(new AcervoResponse(acervo));
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> deleteAcervo(Long id) {
        Optional<Acervo> optional = acervoRepository.findById(id);
        if (optional.isPresent()) {
            acervoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Acervo convertRequestToEntity(AcervoRequest request) {
        Acervo acervo = new Acervo();
        acervo.setTitulo(request.getTitulo());
        acervo.setAutor(request.getAutor());
        acervo.setEditora(request.getEditora());
        acervo.setAssunto(request.getAssunto());
        acervo.setAno(request.getAno());
        acervo.setQtd(request.getQtd());

        return acervo;
    }

    private List<AcervoResponse> convertListToResponseList(List<Acervo> acervos) {
        return acervos.stream().map(AcervoResponse::new).collect(Collectors.toList());
    }
}
