package projeto.techAcademy.dto;

import java.math.BigDecimal;

public record FormaPagamentoRequestDTO(String nome, BigDecimal taxa) {
}
