package com.pay.tools_challange.enums;

public enum TipoPagamento {

    AVISTA("A VISTA"),
    PARCELADO_LOJA("PARCELADO LOJA"),
    PARCELADO_EMISSOR("PARCELADO EMISSOR");

    private String tipoPagamento;

    TipoPagamento(String formaPagamento) {
        this.tipoPagamento = formaPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

}
