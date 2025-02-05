package com.pay.tools_challange.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Embeddable
public class Descricao {

    @NotNull(message = "O campo valor é obrigatório")
    private BigDecimal valor;

    @CreationTimestamp
    private LocalDateTime dataHora;

    @NotBlank(message = "O campo estabelecimento é obrigatório")
    private String estabelecimento;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

}
