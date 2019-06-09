package com.caioguedes.workshopmongo.resources;

import com.caioguedes.workshopmongo.domain.Post;
import com.caioguedes.workshopmongo.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {
  private PostService service;

  @Autowired
  public PostResource(PostService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = service.findById(id);
    return ResponseEntity.ok().body(post);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Post>> find(
      @RequestParam(value = "title", defaultValue = "") String title) {
    return ResponseEntity.ok().body(service.findByTitle(title));
  }
}
