package com.yellow.domain;

import java.util.UUID;

public class Id {
    private final UUID value;

    public Id(UUID value) {
        this.value = value;
    }
    public Id(String value) {
        this.value = UUID.fromString(value);
    }

    public UUID getValue() {
        return value;
    }
    public String getStringValue() {
        return value.toString();
    }
}
