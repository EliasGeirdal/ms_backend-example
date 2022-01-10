package com.yellow.resources.dto.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CreateUserDTO {
    // user and credentials
    private String name, imageUrl, username, email, password;
    // user address
    private AddressDTO address;

    @JsonCreator
    public CreateUserDTO(@JsonProperty("name") String name,
                         @JsonProperty("imageUrl") String imageUrl,
                         @JsonProperty("username") String username,
                         @JsonProperty("email") String email,
                         @JsonProperty("password") String password,
                         @JsonProperty("address") AddressDTO address) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
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

    public AddressDTO getAddress() {
        return address;
    }
}
