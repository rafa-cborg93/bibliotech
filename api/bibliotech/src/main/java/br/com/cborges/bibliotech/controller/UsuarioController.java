package br.com.cborges.bibliotech.controller;

import br.com.cborges.bibliotech.domain.usuario.response.UsuarioResponse;
import br.com.cborges.bibliotech.domain.usuario.request.UsuarioRequest;
import br.com.cborges.bibliotech.domain.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriBuilder){
		return service.createUser(request, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> detalhar(@PathVariable Long id){
		return service.getUser(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequest request ){
		return service.updateUser(id, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remover(@PathVariable Long id){
		return service.deleteUser(id);
	}
	
}
