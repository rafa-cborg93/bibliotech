package br.com.cborges.bibliotech.config.security;

import br.com.cborges.bibliotech.service.AutenticacaoService;
import br.com.cborges.bibliotech.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.cborges.bibliotech.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//configurar autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//configurar autorizacoes
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/acervos").permitAll()
		.antMatchers(HttpMethod.GET,"/acervos/*").permitAll()
		.antMatchers(HttpMethod.POST,"/acervos/*").permitAll()
		.antMatchers(HttpMethod.PUT,"/acervos/*").permitAll()
		.antMatchers(HttpMethod.DELETE,"/acervos/*").permitAll()
		.antMatchers(HttpMethod.GET,"/emprestimos").permitAll()
		.antMatchers(HttpMethod.GET,"/emprestimos/*").permitAll()
		.antMatchers(HttpMethod.POST,"/emprestimos/*").permitAll()
		.antMatchers(HttpMethod.PUT,"/emprestimos/*").permitAll()
		.antMatchers(HttpMethod.DELETE,"/emprestimos/*").permitAll()
		.antMatchers(HttpMethod.GET,"/ususarios/*").permitAll()
		.antMatchers(HttpMethod.POST,"/ususarios/*").permitAll()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().headers().frameOptions().sameOrigin()
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
		}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}

}
