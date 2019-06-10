package com.caioguedes.workshopmongo.domain;

import com.caioguedes.workshopmongo.dto.AuthorDto;
import com.caioguedes.workshopmongo.dto.CommentDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Post implements Serializable {
  @Id
  private String id;
  private Date date;
  private String title;
  private String body;
  private AuthorDto author;
  private List<CommentDto> comments = new ArrayList<>();

  public Post(String id, Date date, String title, String body, AuthorDto author) {
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
    this.author = author;
  }
}
