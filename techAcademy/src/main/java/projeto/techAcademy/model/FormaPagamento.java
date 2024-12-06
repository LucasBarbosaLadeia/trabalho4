package projeto.techAcademy.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "forma_pagamento")
@Entity
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    private Integer IdFormaPagamento;
    @Column
    private String nome;
    @Column
    private BigDecimal taxa;

    public Integer getIdFormaPagamento() {
        return IdFormaPagamento;
    }

    public void setIdFormaPagamento(Integer idFormaPagamento) {
        IdFormaPagamento = idFormaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}
