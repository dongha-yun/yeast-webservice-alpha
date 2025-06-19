package com.yeastriver.webservice.config.auth.dto;

import com.yeastriver.webservice.domain.user.Users;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUsers implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUsers(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.picture = users.getPicture();
    }
}
