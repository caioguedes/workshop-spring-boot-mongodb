package com.caioguedes.workshopmongo.exception;

public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(String message) {
    super(message);
  }
}
