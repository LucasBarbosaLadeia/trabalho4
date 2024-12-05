package projeto.techAcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Pagamento {
    @EmbeddedId
    private PagamentoPK id;
    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @JsonIgnoreProperties("FormaPagamento")
    private Pedido pedido;
    @ManyToOne
    @MapsId("idFormaPagamento")
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id_forma_pagamento")
    private FormaPagamento formaPagamento;
    @Column(name = "data_pagamento")
    private LocalDate DataPagamento;
    @Column(name = "valor_pago")
    private BigDecimal ValorPago;

    public PagamentoPK getId() {
        return id;
    }

    public void setId(PagamentoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDate getDataPagamento() {
        return DataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        DataPagamento = dataPagamento;
    }

    public BigDecimal getValorPago() {
        return ValorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        ValorPago = valorPago;
    }
}
