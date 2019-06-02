package com.caioguedes.workshopmongo.services;

import com.caioguedes.workshopmongo.domain.User;
import com.caioguedes.workshopmongo.dto.UserDto;
import com.caioguedes.workshopmongo.exception.ObjectNotFoundException;
import com.caioguedes.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(String id) {
    Optional<User> user = repository.findById(id);
    if (!user.isPresent()) {
      throw new ObjectNotFoundException("User was not found.");
    }
    return user.get();
  }

  public User insert(User user) {
    return repository.save(user);
  }

  public User insert(UserDto userDto) {
    User user = new User(null, userDto.getName(), userDto.getEmail());
    return repository.save(user);
  }
}
