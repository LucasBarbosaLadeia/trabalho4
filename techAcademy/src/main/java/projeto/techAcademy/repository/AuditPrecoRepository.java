package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.AuditPreco;

public interface AuditPrecoRepository extends JpaRepository <AuditPreco, Integer> {
}
