package com.pay.tools_challange.exception;

public class TransacaoCanceladaException extends RuntimeException {
  private final String id;

  public TransacaoCanceladaException(String message, String id) {
    super(String.format("%s (ID: %s)", message, id));
    this.id = id;
  }

  public TransacaoCanceladaException(String message, String id, Throwable cause) {
    super(String.format("%s (ID: %s)", message, id), cause);
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
