package com.caioguedes.workshopmongo.config;

import com.caioguedes.workshopmongo.domain.Post;
import com.caioguedes.workshopmongo.domain.User;
import com.caioguedes.workshopmongo.dto.AuthorDto;
import com.caioguedes.workshopmongo.dto.CommentDto;
import com.caioguedes.workshopmongo.repository.PostRepository;
import com.caioguedes.workshopmongo.repository.UserRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import org.springframework.context.annotation.Profile;

@Profile("demo")
@Configuration
public class Instantiation implements CommandLineRunner {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@example.com");
        User alex = new User(null, "Alex Green", "alex@example.com");
        User bob = new User(null, "Bob Grey", "bob@example.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(
            null,
            new Date(),
            "Partiu viagem",
            "Vou viajar para São Paulo. Abraços!",
            new AuthorDto(maria));
        Post post2 = new Post(
            null,
            new Date(),
            "Bom dia",
            "Acordei feliz hoje!",
            new AuthorDto(maria));

        CommentDto comment1 = new CommentDto("Boa viagem mano!", new Date(), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto("Aproveite", new Date(), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", new Date(), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
