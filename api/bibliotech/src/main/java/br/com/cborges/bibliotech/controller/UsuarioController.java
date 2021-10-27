package br.com.cborges.bibliotech.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cborges.bibliotech.controller.dto.DetalheDoUsuarioDto;
import br.com.cborges.bibliotech.controller.dto.UsuarioDto;
import br.com.cborges.bibliotech.controller.form.AtualizarUsuarioForm;
import br.com.cborges.bibliotech.controller.form.UsuarioForm;
import br.com.cborges.bibliotech.modelo.Usuario;
import br.com.cborges.bibliotech.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converter(usuarioRepository);
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheDoUsuarioDto> detalhar(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new DetalheDoUsuarioDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioForm form  ){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
