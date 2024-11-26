package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.FormaPagamentoRequestDTO;
import projeto.techAcademy.dto.PedidoRequestDTO;
import projeto.techAcademy.model.FormaPagamento;
import projeto.techAcademy.model.Pedido;
import projeto.techAcademy.repository.FormaPagamentoRepository;
import projeto.techAcademy.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/FormaPagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> formasdepagamentos = this.repository.findAll();
        return ResponseEntity.ok(formasdepagamentos);
    }

    @GetMapping("/{idFormaPagamento}")
    public ResponseEntity<FormaPagamento> findById(@PathVariable Integer idFormaPagamento) {
        FormaPagamento formaPagamento = this.repository.findById(idFormaPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(formaPagamento);
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> save( @RequestBody FormaPagamentoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }


        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setNome(dto.nome());
        formaPagamento.setTaxa(dto.taxa());

        this.repository.save(formaPagamento);
        return ResponseEntity.ok(formaPagamento);
    }

    @DeleteMapping("/{idFormaPagamento}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFormaPagamento) {
        FormaPagamento formaPagamento = this.repository.findById(idFormaPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(formaPagamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idFormaPagamento}")
    public ResponseEntity<FormaPagamento> update(@PathVariable Integer idFormaPagamento, @RequestBody FormaPagamentoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        FormaPagamento formaPagamento = this.repository.findById(idFormaPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        formaPagamento.setNome(dto.nome());
        formaPagamento.setTaxa(dto.taxa());
        this.repository.save(formaPagamento);
        return ResponseEntity.ok(formaPagamento);
    }
}
