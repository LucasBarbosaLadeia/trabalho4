package projeto.techAcademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PagamentoPK {
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "id_forma_pagamento")
    private Integer idFormaPagamento;
}

