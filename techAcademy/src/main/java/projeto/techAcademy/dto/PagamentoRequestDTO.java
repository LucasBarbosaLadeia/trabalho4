package projeto.techAcademy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoRequestDTO( BigDecimal ValorPago, LocalDate DataPagamento) {
}
