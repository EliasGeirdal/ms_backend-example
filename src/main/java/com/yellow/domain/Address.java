package com.yellow.domain;

public class Address {
    private String city, street;
    private int zipcode, street_number;
    private String floor;

    public Address(String city, String street, int zipcode, int street_number, String floor) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.street_number = street_number;
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public int getStreet_number() {
        return street_number;
    }

    public String getFloor() {
        return floor;
    }
}
