package com.pay.tools_challange.model;

import com.pay.tools_challange.enums.TipoPagamento;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class FormaPagamento {

    @NotBlank(message = "O campo tipo de pagamento é obrigatório")
    private TipoPagamento tipo;

    @NotBlank(message = "O campo quantidade de parcelas é obrigatório")
    private String parcelas;

}
