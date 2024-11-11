package projeto.techAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.techAcademy.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
