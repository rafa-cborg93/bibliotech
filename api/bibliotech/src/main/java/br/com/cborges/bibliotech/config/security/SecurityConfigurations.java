package br.com.cborges.bibliotech.config.security;

import br.com.cborges.bibliotech.constants.Constants;
import br.com.cborges.bibliotech.repository.UsuarioRepository;
import br.com.cborges.bibliotech.service.AutenticacaoService;
import br.com.cborges.bibliotech.service.TokenService;
import lombok.RequiredArgsConstructor;
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

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {


    private final TokenService tokenService;

    private final AutenticacaoService autenticacaoService;

    private final UsuarioRepository usuarioRepository;

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
                .antMatchers(HttpMethod.GET, "/acervos").permitAll()
                .antMatchers(HttpMethod.GET, Constants.ACERVOS_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.POST, Constants.ACERVOS_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.PUT, Constants.ACERVOS_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.DELETE, Constants.ACERVOS_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.GET, "/emprestimos").permitAll()
                .antMatchers(HttpMethod.GET, Constants.EMPRESTIMO_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.POST, Constants.EMPRESTIMO_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.PUT, Constants.EMPRESTIMO_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.DELETE, Constants.EMPRESTIMO_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.GET, "/ususarios/*").permitAll()
                .antMatchers(HttpMethod.POST, "/ususarios/*").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
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
