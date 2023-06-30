package br.com.cborges.bibliotech.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cborges.bibliotech.controller.dto.AcervoDto;
import br.com.cborges.bibliotech.controller.dto.DetalheDoAcervoDto;
import br.com.cborges.bibliotech.controller.form.AcervoForm;
import br.com.cborges.bibliotech.controller.form.AtualizaAcervoForm;
import br.com.cborges.bibliotech.entity.Acervo;
import br.com.cborges.bibliotech.repository.AcervoRepository;


@RestController
@RequestMapping("/acervos")
@CrossOrigin(origins = "*")
public class AcervoController {
	
	@Autowired
	private AcervoRepository acervoRepository;
	
	@GetMapping
	public List<AcervoDto> lista(String titulo){
		if(titulo==null) {
			List<Acervo> acervos = acervoRepository.findAll();
			return AcervoDto.converter(acervos);
		}else {
			List<Acervo> acervos = acervoRepository.findByTitulo(titulo);
			return AcervoDto.converter(acervos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AcervoDto> cadastrar(@RequestBody @Valid AcervoForm form, UriComponentsBuilder uriBuilder ){
		Acervo acervo = form.converter(acervoRepository);
		acervoRepository.save(acervo);
		
		URI uri = uriBuilder.path("/acervos/{id}").buildAndExpand(acervo.getId()).toUri();
		return ResponseEntity.created(uri).body(new AcervoDto(acervo));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheDoAcervoDto> detalhar(@PathVariable Long id){
		Optional<Acervo> optional = acervoRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new DetalheDoAcervoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AcervoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaAcervoForm form){
		Optional<Acervo> optional = acervoRepository.findById(id);
		if(optional.isPresent()) {
			Acervo acervo = form.atualizar(id, acervoRepository);
			return ResponseEntity.ok(new AcervoDto(acervo));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Acervo> optional = acervoRepository.findById(id);
		if(optional.isPresent()) {
			acervoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
