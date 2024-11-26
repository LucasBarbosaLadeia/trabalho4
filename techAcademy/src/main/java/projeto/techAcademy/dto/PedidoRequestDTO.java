package projeto.techAcademy.dto;

import projeto.techAcademy.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record PedidoRequestDTO(Integer idUsuario, Integer quantidadePedido, LocalDate dataPedido, String status) {
}
