package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository <FormaPagamento, Integer> {
}
