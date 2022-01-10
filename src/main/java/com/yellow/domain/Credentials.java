package com.yellow.domain;

import com.yellow.domain.exception.DomainValidationException;
import com.yellow.service.exception.Sid;

public class Credentials {
    private String username;
    private String email;
    private String password;

    public Credentials(String username, String email, String password) throws DomainValidationException {
        if (username.length() >= 20) {
            throw new DomainValidationException(Sid.USERNAME_INVALID, "Username is restricted to maximum 20 characters.");
        }
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
