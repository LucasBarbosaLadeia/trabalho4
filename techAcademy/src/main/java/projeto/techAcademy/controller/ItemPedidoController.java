package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.ItemPedidoRequestDTO;
import projeto.techAcademy.dto.ItemRequestDTO;
import projeto.techAcademy.dto.PedidoRequestDTO;
import projeto.techAcademy.model.Item;
import projeto.techAcademy.model.ItemPedido;
import projeto.techAcademy.model.Pedido;
import projeto.techAcademy.model.itemPedidoPK;
import projeto.techAcademy.repository.ItemPedidoRepository;
import projeto.techAcademy.repository.ItemRepository;
import projeto.techAcademy.repository.PedidoRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/Itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

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

        itemPedidoPK id = new itemPedidoPK();
        id.setIdItem(dto.idItem());
        id.setIdPedido(dto.idPedido());

        Item item = itemRepository.findById(dto.idItem())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        Pedido pedido = pedidoRepository.findById(dto.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(id);
        itemPedido.setItem(item);
        itemPedido.setPedido(pedido);
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

    @PatchMapping("/{idItemPedido}")
    public ResponseEntity<ItemPedido> update(@PathVariable Integer idItemPedido, @RequestBody ItemPedidoRequestDTO dto) {

        ItemPedido itemPedido = this.repository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        itemPedido.setQuantidade(dto.quantidade());
        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }
}