package com.pay.tools_challange.enums;

public enum StatusTransacao {

    AUTORIZADO("AUTORIZADO"),
    NEGADO("NEGADO");

    private String statusTransacao;

    StatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

}
