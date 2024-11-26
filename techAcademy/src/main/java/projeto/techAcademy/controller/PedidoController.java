package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.PedidoRequestDTO;
import projeto.techAcademy.model.Pedido;
import projeto.techAcademy.repository.PedidoRepository;


import java.util.List;

@RestController
@RequestMapping("/api/Pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer idPedido) {
        Pedido pedido = this.repository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> save( @RequestBody PedidoRequestDTO dto) {
        if (dto.status().isEmpty()) {
            return ResponseEntity.status(400).build();
        }


        Pedido pedido = new Pedido();
        pedido.setIdUsuario(dto.idUsuario());
        pedido.setDataPedido(dto.dataPedido());
        pedido.setQuantidadePedido(dto.quantidadePedido());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPedido) {
        Pedido pedido = this.repository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<Pedido> update(@PathVariable Integer idPedido, @RequestBody PedidoRequestDTO dto) {
        if (dto.status().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Pedido pedido = this.repository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));

        pedido.setStatus(dto.status());
        pedido.setIdUsuario(dto.idUsuario());
        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
