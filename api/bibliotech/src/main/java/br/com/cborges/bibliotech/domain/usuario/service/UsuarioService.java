package br.com.cborges.bibliotech.domain.usuario.service;

import br.com.cborges.bibliotech.domain.usuario.request.UsuarioRequest;
import br.com.cborges.bibliotech.domain.usuario.response.UsuarioResponse;
import br.com.cborges.bibliotech.entity.Usuario;
import br.com.cborges.bibliotech.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioResponse> createUser(UsuarioRequest request, UriComponentsBuilder uriBuilder) {
        Usuario usuario = convertRequestToEntity(request);
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }

    public ResponseEntity<UsuarioResponse> getUser(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new UsuarioResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UsuarioResponse> updateUser(Long id, UsuarioRequest request) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            Usuario usuario = convertRequestToEntity(request);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok(new UsuarioResponse(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteUser(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Usuario convertRequestToEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());

        return usuario;
    }
}
