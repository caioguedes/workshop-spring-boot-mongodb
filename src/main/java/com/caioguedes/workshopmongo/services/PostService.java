package com.caioguedes.workshopmongo.services;

import com.caioguedes.workshopmongo.domain.Post;
import com.caioguedes.workshopmongo.exception.ObjectNotFoundException;
import com.caioguedes.workshopmongo.repository.PostRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private PostRepository repository;

  @Autowired
  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public Post findById(String id) {
    Optional<Post> post = repository.findById(id);
    if (!post.isPresent()) {
      throw new ObjectNotFoundException("Post was not found.");
    }
    return post.get();
  }
}
