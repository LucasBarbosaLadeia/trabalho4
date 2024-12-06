package projeto.techAcademy.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Table
@Entity
public class AuditPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_audit_preco_item")
    private Integer idAuditPreco;
    @JoinColumn(name = "id_item")
    @ManyToOne
    private Item item;
    @Column(name = "data_modificacao")
    private LocalDate dataModificacao;
    @Column(name = "preco_antigo")
    private BigDecimal precoAntigo;
    @Column(name = "preco_novo")
    private BigDecimal precoNovo;
    @Column(name = "motivo")
    private String Motivo;

    public Integer getIdAuditPrecoItem() {
        return idAuditPreco;
    }

    public void setIdAuditPrecoItem(Integer idAuditPrecoItem) {
        this.idAuditPreco = idAuditPrecoItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public BigDecimal getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(BigDecimal precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public BigDecimal getPrecoNovo() {
        return precoNovo;
    }

    public void setPrecoNovo(BigDecimal precoNovo) {
        this.precoNovo = precoNovo;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }
}
