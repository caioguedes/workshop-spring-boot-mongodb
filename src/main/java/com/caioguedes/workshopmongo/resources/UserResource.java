package com.caioguedes.workshopmongo.resources;

import com.caioguedes.workshopmongo.domain.User;
import com.caioguedes.workshopmongo.dto.UserDto;
import com.caioguedes.workshopmongo.services.UserService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> findById(@PathVariable String id) {
    UserDto user = new UserDto(service.findById(id));
    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
    User user = service.insert(userDto);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(user.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
