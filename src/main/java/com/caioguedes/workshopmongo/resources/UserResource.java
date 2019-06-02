package com.caioguedes.workshopmongo.resources;

import com.caioguedes.workshopmongo.domain.User;
import com.caioguedes.workshopmongo.dto.UserDto;
import com.caioguedes.workshopmongo.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {
  private UserService service;

  @Autowired
  public UserResource(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> findAll() {
    List<UserDto> list = service.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(list);
  }
}
