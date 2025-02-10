package com.pay.tools_challange.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pay.tools_challange.enums.StatusTransacao;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DescricaoDTO(

        @NotNull(message = "O campo valor é obrigatório")
        BigDecimal valor,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataHora,

        String estabelecimento,

        String nsu,

        String codigoAutorizacao,

        StatusTransacao status

) {
}
