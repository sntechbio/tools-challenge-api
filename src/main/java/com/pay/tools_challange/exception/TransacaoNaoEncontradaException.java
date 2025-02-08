package com.pay.tools_challange.exception;

public class TransacaoNaoEncontradaException extends RuntimeException {

  public TransacaoNaoEncontradaException(String message) {
    super(message);
  }

  public TransacaoNaoEncontradaException(String message, String id) {
    super(String.format("%s (ID: %s)", message, id));
  }

}
