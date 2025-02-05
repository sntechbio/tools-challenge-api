package com.pay.tools_challange.model;

import com.pay.tools_challange.enums.StatusTransacao;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Embeddable
public class Descricao {

    @NotNull(message = "O campo valor é obrigatório")
    private BigDecimal valor;

    private String nsu;

    private String codigoAutorizacao;

    private StatusTransacao status;

    @NotBlank(message = "O campo estabelecimento é obrigatório")
    private String estabelecimento;

    @CreationTimestamp
    private LocalDateTime dataHora;

    @UpdateTimestamp
    private LocalDateTime dataHoraAtualizacao;

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

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(String codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }
}
