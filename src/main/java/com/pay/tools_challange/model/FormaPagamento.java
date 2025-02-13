package com.pay.tools_challange.model;

import com.pay.tools_challange.enums.TipoPagamento;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class FormaPagamento {

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O campo tipo de pagamento é obrigatório")
    private TipoPagamento tipo;

    @NotBlank(message = "O campo quantidade de parcelas é obrigatório")
    private String parcelas;

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }
}
