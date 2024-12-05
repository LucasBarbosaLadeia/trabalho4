package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido,Integer>{
}
