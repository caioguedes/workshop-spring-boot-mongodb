package com.caioguedes.workshopmongo.resources.exception;

import com.caioguedes.workshopmongo.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError error = new StandardError(
      status.value(),
      "Not found.",
      exception.getMessage()
    );
    return ResponseEntity.status(status).body(error);
  }
}
