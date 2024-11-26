package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer> {
}
