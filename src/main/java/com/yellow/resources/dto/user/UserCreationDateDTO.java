package com.yellow.resources.dto.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserCreationDateDTO {
    private LocalDateTime creation_date;

    public UserCreationDateDTO(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }
}
