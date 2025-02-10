package com.pay.tools_challange.dto;

import com.pay.tools_challange.enums.TipoPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FormaPagamentoDTO(
        @Enumerated(EnumType.STRING)
        @NotNull(message = "O tipo de pagamento deve ser preenchido")
        TipoPagamento tipo,

        @NotBlank(message = "O campo quantidade de parcelas deve ser preenchido")
        String parcelas
) {
}
