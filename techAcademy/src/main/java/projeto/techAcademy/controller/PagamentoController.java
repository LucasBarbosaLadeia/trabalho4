package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.PagamentoRequestDTO;
import projeto.techAcademy.model.FormaPagamento;
import projeto.techAcademy.model.Pagamento;
import projeto.techAcademy.model.PagamentoPK;
import projeto.techAcademy.model.Pedido;
import projeto.techAcademy.repository.FormaPagamentoRepository;
import projeto.techAcademy.repository.PagamentoRepository;
import projeto.techAcademy.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController{

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = this.repository.findAll();
        return ResponseEntity.ok(pagamentos);
    }


    @PostMapping
    public ResponseEntity<Pagamento> save( @RequestBody PagamentoRequestDTO dto) {

            PagamentoPK id = new PagamentoPK();
            id.setIdPedido(dto.idPedido());
            id.setIdFormaPagamento(dto.idFormaPagamento());
        Pedido pedido = pedidoRepository.findById(dto.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.idFormaPagamento())
                .orElseThrow(() -> new IllegalArgumentException("forma de pagamento não encontrada"));

        Pagamento pagamento = new Pagamento();
        pagamento.setId(id);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setPedido(pedido);
        pagamento.setValorTotal(dto.ValorTotal());
        pagamento.setDataPagamento(dto.DataPagamento());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }




}

