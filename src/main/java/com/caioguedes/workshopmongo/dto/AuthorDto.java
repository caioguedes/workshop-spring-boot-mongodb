package com.caioguedes.workshopmongo.dto;

import com.caioguedes.workshopmongo.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDto implements Serializable {
  private String id;
  private String name;

  public AuthorDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }
}
