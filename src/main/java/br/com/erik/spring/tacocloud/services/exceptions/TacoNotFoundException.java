package br.com.erik.spring.tacocloud.services.exceptions;

public class TacoNotFoundException extends RuntimeException {
  public TacoNotFoundException(String message) {
    super(message);
  }
}
