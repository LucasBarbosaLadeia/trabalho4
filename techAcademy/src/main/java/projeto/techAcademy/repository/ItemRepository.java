package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
