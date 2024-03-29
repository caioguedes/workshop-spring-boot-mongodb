package com.caioguedes.workshopmongo.repository;

import com.caioguedes.workshopmongo.domain.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  public List<Post> findByTitleContainingIgnoreCase(String text);
}
