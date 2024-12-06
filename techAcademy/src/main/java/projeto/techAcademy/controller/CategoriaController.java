package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.techAcademy.model.AuditPreco;
import projeto.techAcademy.model.Categoria;
import projeto.techAcademy.repository.AuditPrecoRepository;
import projeto.techAcademy.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = this.repository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer idCategoria) {
        Categoria categoria = this.repository.findById(idCategoria)
                .orElseThrow(() -> new IllegalArgumentException("categoria não foi encontrado"));
        return ResponseEntity.ok(categoria);
    }

}

