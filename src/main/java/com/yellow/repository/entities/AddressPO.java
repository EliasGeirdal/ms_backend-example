package com.yellow.repository.entities;

import com.yellow.domain.Address;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Address")
@NamedQueries({

})
public class AddressPO {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    // city, street, zipcode, street_number, floor
    @Column(name = "City", columnDefinition = "varchar(100)")
    private String city;

    @Column(name = "Street", columnDefinition = "varchar(100)")
    private String street;

    @Column(name = "Zipcode", columnDefinition = "int")
    private String zipcode;

    @Column(name = "Street_number", columnDefinition = "int")
    private String street_number;

    @Column(name = "Floor", columnDefinition = "varchar(50)")
    private String floor;

    public AddressPO() {
        // JPA
    }

    public AddressPO(String city, String street, String zipcode, String street_number, String floor) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.street_number = street_number;
        this.floor = floor;
    }

    public UUID getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet_number() {
        return street_number;
    }

    public String getFloor() {
        return floor;
    }

    public Address toAddress() {
        return new Address(getCity(), getStreet(), Integer.parseInt(getZipcode()), Integer.parseInt(getStreet_number()), getFloor());
    }
}
