package com.pay.tools_challange.dto;

import com.pay.tools_challange.enums.TipoPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record FormaPagamentoDTO(
        @Enumerated(EnumType.STRING)
        TipoPagamento tipoPagamento,

        String parcelas
) {
}
