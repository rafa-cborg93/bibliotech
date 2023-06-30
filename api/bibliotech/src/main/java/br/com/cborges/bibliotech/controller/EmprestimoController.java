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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cborges.bibliotech.controller.dto.DetalheDoEmprestimoDto;
import br.com.cborges.bibliotech.controller.dto.EmprestimoDto;
import br.com.cborges.bibliotech.controller.form.EmprestimoForm;
import br.com.cborges.bibliotech.entity.Emprestimo;
import br.com.cborges.bibliotech.repository.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimos")
@CrossOrigin(origins = "*")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@GetMapping
	public List<EmprestimoDto> lista(String acervoTitulo){
		if(acervoTitulo==null) {
			List<Emprestimo> emprestimos = emprestimoRepository.findAll();
			return EmprestimoDto.converter(emprestimos);
		}else {
			List<Emprestimo> emprestimos = emprestimoRepository.findByAcervoTitulo(acervoTitulo);
			return EmprestimoDto.converter(emprestimos);
		}
	}
	@PostMapping
	@Transactional
	public ResponseEntity<EmprestimoDto> cadastrar(@RequestBody @Valid EmprestimoForm form, UriComponentsBuilder uriBuilder){
		Emprestimo emprestimo = form.converter(emprestimoRepository);
		emprestimoRepository.save(emprestimo);
		
		URI uri = uriBuilder.path("/emprestimos/{id}").buildAndExpand(emprestimo.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmprestimoDto(emprestimo));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DetalheDoEmprestimoDto> detalhar(@PathVariable Long id){
		Optional<Emprestimo> optional = emprestimoRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new DetalheDoEmprestimoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Emprestimo> optional = emprestimoRepository.findById(id);
		if(optional.isPresent()) {
			emprestimoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
