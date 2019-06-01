package com.caioguedes.workshopmongo.config;

import com.caioguedes.workshopmongo.domain.User;
import com.caioguedes.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private UserRepository repository;

    @Autowired
    public Instantiation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@example.com");
        User alex = new User(null, "Alex Green", "alex@example.com");
        User bob = new User(null, "Bob Grey", "bob@example.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
