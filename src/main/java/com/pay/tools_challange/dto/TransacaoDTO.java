package com.pay.tools_challange.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TransacaoDTO(

        @NotBlank(message = "O campo cartão é obrigatório")
        String cartao,

        String id,

        @Valid
        DescricaoDTO descricao,

        @Valid
        FormaPagamentoDTO formaPagamento

) {
}
