package com.yellow.service.request;

import com.yellow.domain.Address;
import com.yellow.domain.Credentials;
import com.yellow.resources.dto.user.AddressDTO;

public class CreateUserRequest {
    private String name, imageUrl;
    private Credentials credentials;
    private Address address;

    public CreateUserRequest(String name, String imageUrl, Credentials credentials, Address address) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.credentials = credentials;
        this.address = address;
    }
    
    public String getImageUrl() {
        return imageUrl;
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
