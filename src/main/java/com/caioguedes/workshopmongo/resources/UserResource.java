package com.caioguedes.workshopmongo.resources;

import com.caioguedes.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@example.com");
        User alex = new User("2", "Alex Green", "alex@example.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}
