package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projeto.techAcademy.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
