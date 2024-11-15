package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.UsuarioRequestDTO;
import projeto.techAcademy.model.Usuario;
import projeto.techAcademy.repository.UsuarioRepository;
import java.util.List;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer idUsuario) {
        Usuario usuario = this.repository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> save( @RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Integer idUsuario) {
        Usuario usuario = this.repository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> update(@PathVariable Integer idUsuario, @RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuario usuario = this.repository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        usuario.setNome(dto.nome());
        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}