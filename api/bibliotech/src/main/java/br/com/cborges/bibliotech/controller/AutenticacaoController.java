package br.com.cborges.bibliotech.controller;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cborges.bibliotech.service.TokenService;
import br.com.cborges.bibliotech.dto.TokenDto;
import br.com.cborges.bibliotech.dto.LoginForm;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AutenticacaoController {
	private final AuthenticationManager authManager;

	private final TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
