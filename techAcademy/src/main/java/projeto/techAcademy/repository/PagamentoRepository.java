package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento, Integer> {
}
