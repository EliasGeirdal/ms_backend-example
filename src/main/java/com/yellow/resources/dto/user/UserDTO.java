package com.yellow.resources.dto.user;

import com.yellow.domain.Address;
import com.yellow.domain.Credentials;
import com.yellow.domain.Id;

import java.time.LocalDate;

public class UserDTO {
    private Id id;
    private String name;
    private String imageUrl;
    private Credentials credentials;
    private Address address;

    public UserDTO(Id id, String name, String imageUrl, Credentials credentials, Address address) {
        this.id = id;
        this.name = name;
        this.credentials = credentials;
        this.address = address;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Address getAddress() {
        return address;
    }
}
