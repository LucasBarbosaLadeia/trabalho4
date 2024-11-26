package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.PagamentoRequestDTO;
import projeto.techAcademy.model.Pagamento;
import projeto.techAcademy.model.Pedido;
import projeto.techAcademy.repository.PagamentoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController{

    @Autowired
    private PagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = this.repository.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> findById(@PathVariable Integer idPagamento) {
        Pagamento Pagamento = this.repository.findById(idPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(Pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> save( @RequestBody PagamentoRequestDTO dto) {


        Pagamento pagamento = new Pagamento();
        pagamento.setValorPago(dto.ValorPago());
        pagamento.setDataPagamento(dto.DataPagamento());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{idPagamento}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPagamento) {
        Pagamento Pagamento = this.repository.findById(idPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(Pagamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> update(@PathVariable Integer idFormaPagamento, @RequestBody PagamentoRequestDTO dto) {


        Pagamento Pagamento = this.repository.findById(idFormaPagamento)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        Pagamento.setValorPago(dto.ValorPago());
        this.repository.save(Pagamento);
        return ResponseEntity.ok(Pagamento);
    }
}

