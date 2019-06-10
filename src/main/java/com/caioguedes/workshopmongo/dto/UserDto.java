package com.caioguedes.workshopmongo.dto;

import com.caioguedes.workshopmongo.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private String id;
    private String name;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
