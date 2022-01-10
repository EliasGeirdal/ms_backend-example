package com.yellow.resources.dto.advertisement;

import java.time.LocalDateTime;

public class AdvertisementCreationDateDTO {

    private LocalDateTime creation_date;

    public AdvertisementCreationDateDTO(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }
}
