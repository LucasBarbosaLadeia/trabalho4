package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
