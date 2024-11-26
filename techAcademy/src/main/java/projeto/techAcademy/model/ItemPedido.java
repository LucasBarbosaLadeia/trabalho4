package projeto.techAcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Item_Pedido")
public class ItemPedido {
    @EmbeddedId
    private itemPedidoPK id;
    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @JsonIgnoreProperties("Pedido")
    private Item item;
    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;
    @Column
    private Integer quantidade;

    public itemPedidoPK getId() {
        return id;
    }

    public void setId(itemPedidoPK id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
