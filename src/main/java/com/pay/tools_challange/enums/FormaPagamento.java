package com.pay.tools_challange.enums;

public enum FormaPagamento {

    AVISTA("A VISTA"),
    PARCELADO_LOJA("PARCELADO LOJA"),
    PARCELADO_EMISSOR("PARCELADO EMISSOR");

    private String formaPagamento;

    FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
