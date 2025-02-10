package com.pay.tools_challange.dto;

import jakarta.validation.Valid;

public record PagamentoDTO(@Valid TransacaoDTO transacao) {
}
