package com.yellow.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private Id id;
    private String name;
    private String imageUrl;
    private Credentials credentials;
    private Address address;
    private List<Advertisement> advertisements = new ArrayList<>();

    public User(Id id, String name, String imageUrl, Credentials credentials, Address address) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.credentials = credentials;
        this.address = address;
    }

    public User(String name, String imageUrl, Credentials credentials, Address address) {
        this.id = new Id(UUID.randomUUID());
        this.name = name;
        this.imageUrl = imageUrl;
        this.credentials = credentials;
        this.address = address;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
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
