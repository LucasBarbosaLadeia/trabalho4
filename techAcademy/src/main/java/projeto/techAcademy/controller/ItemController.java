package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.ItemRequestDTO;
import projeto.techAcademy.dto.UsuarioRequestDTO;
import projeto.techAcademy.model.Categoria;
import projeto.techAcademy.model.Eletronicos;
import projeto.techAcademy.model.Item;
import projeto.techAcademy.model.Usuario;
import projeto.techAcademy.repository.CategoriaRepository;
import projeto.techAcademy.repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = this.repository.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{idItem}")
    public ResponseEntity<Item> findById(@PathVariable Integer idItem) {
        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("item não foi encontrado"));
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody ItemRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        Categoria categoria = categoriaRepository.findById(dto.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException("categoria não encontrada"));


        Item item = new Item();
        item.setCategoria(categoria);
        item.setNomeItem(dto.nome());
        item.setDescricaoItem(dto.descricao());
        item.setQuantidadeItem(dto.quantidade());
        item.setPreco(dto.preco());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> delete(@PathVariable Integer idItem) {
        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("item não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idItem}")
    public ResponseEntity<Item> update(@PathVariable Integer idItem, @RequestBody ItemRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("item não foi encontrado"));

        item.setNomeItem(dto.nome());
        item.setDescricaoItem(dto.descricao());
        item.setQuantidadeItem(dto.quantidade());
        item.setPreco(dto.preco());
        this.repository.save(item);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/preco/{idItem}")
    public ResponseEntity<Item> updatePreco(@PathVariable Integer idItem, @RequestBody ItemRequestDTO dto) {

        Item item = this.repository.findById(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        item.setPreco(dto.preco());
        this.repository.save(item);
        return ResponseEntity.ok(item);
    }
}