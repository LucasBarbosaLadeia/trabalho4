package projeto.techAcademy.dto;

import java.math.BigDecimal;

public record ItemRequestDTO(String nome, String descricao, Integer quantidade, BigDecimal preco) {
}
