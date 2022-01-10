package com.yellow.domain;

import java.util.UUID;

public class Advertisement {
    private Id Id;
    private AdvertisementDetails advertisementDetails;
    private User user;

    public Advertisement(Id id, AdvertisementDetails advertisementDetails, User user) {
        this.Id = id;
        this.advertisementDetails = advertisementDetails;
        this.user = user;
    }

    public AdvertisementDetails getAdvertisementDetails() {
        return advertisementDetails;
    }

    public Id getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }
}
