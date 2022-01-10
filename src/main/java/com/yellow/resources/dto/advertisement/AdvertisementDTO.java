package com.yellow.resources.dto.advertisement;

import com.yellow.domain.Id;
import com.yellow.resources.dto.user.UserDTO;

public class AdvertisementDTO {

    private Id id;
    private AdvertisementDetailsDTO details;
    private UserDTO user;

    public AdvertisementDTO(Id id, AdvertisementDetailsDTO details, UserDTO user) {
        this.id = id;
        this.details = details;
        this.user = user;
    }

    public AdvertisementDetailsDTO getDetails() {
        return details;
    }

    public Id getId() {
        return id;
    }

    public UserDTO getUser() {
        return user;
    }
}
