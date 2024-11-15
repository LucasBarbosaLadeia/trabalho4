package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.ItemRequestDTO;
import projeto.techAcademy.dto.UsuarioRequestDTO;
import projeto.techAcademy.model.Item;
import projeto.techAcademy.model.Usuario;
import projeto.techAcademy.repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Item")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = this.repository.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{idItem}")
    public ResponseEntity<Item> findById(@PathVariable Integer idItem) {
        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> save( @RequestBody ItemRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Item item = new Item();
        item.setNomeItem(dto.nome());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> delete(@PathVariable Integer idItem) {
        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idItem}")
    public ResponseEntity<Item> update(@PathVariable Integer idItem, @RequestBody ItemRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build(); 
        }

        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        item.setNomeItem(dto.nome());
        this.repository.save(item);
        return ResponseEntity.ok(item);
    }
}
