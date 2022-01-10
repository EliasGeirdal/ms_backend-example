package com.yellow.resources.dto.user;

public class AddressDTO {

    private String city, street, floor;
    private int zipcode, street_number;

    public AddressDTO(String city, String street, String floor, int zipcode, int street_number) {
        this.city = city;
        this.street = street;
        this.floor = floor;
        this.zipcode = zipcode;
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getFloor() {
        return floor;
    }

    public int getZipcode() {
        return zipcode;
    }

    public int getStreet_number() {
        return street_number;
    }
}
