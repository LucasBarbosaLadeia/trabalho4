package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.ItemPedidoRequestDTO;
import projeto.techAcademy.dto.ItemRequestDTO;
import projeto.techAcademy.model.Item;
import projeto.techAcademy.model.ItemPedido;
import projeto.techAcademy.repository.ItemPedidoRepository;
import projeto.techAcademy.repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itemsPedidos = this.repository.findAll();
        return ResponseEntity.ok(itemsPedidos);
    }

    @GetMapping("/{idItemPedido}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Integer idItemPedido) {
        ItemPedido itemPedido = this.repository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(itemPedido);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedidoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(dto.quantidade());

        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }

    @DeleteMapping("/{idItemPedido}")
    public ResponseEntity<Void> delete(@PathVariable Integer idItemPedido) {
        ItemPedido itemPedido = this.repository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(itemPedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idItemPedido}")
    public ResponseEntity<ItemPedido> update(@PathVariable Integer idItemPedido, @RequestBody ItemPedidoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        ItemPedido itemPedido = this.repository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        itemPedido.setQuantidade(dto.quantidade());
        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }
}