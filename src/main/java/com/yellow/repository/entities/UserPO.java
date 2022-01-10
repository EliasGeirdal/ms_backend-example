package com.yellow.repository.entities;

import com.yellow.domain.Credentials;
import com.yellow.domain.User;
import com.yellow.domain.exception.DomainValidationException;
import com.yellow.resources.Mapper;
import com.yellow.service.exception.InternalServerException;
import com.yellow.service.exception.Sid;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Adv_User")
@NamedQueries({
        @NamedQuery(name = "UserPO.findUsers",
                query = "Select u FROM UserPO u"),
})
public class UserPO {
    public static final String FIND_USERS = "UserPO.findUsers";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    public UUID Id;

    @Column(name = "Name", columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "ImageUrl", columnDefinition = "VARCHAR(200)")
    private String imageUrl;

    @Column(name = "Username", columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(name = "Email", columnDefinition = "VARCHAR(200)")
    private String email;

    @Column(name = "Password", columnDefinition = "VARCHAR(500)")
    private String password;

    @Column(name = "creation_date", columnDefinition = "DATETIME")
    private LocalDateTime creation_date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdvertisementPO> advertisements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_fk", referencedColumnName = "id")
    private AddressPO address;

    public UserPO() {
        //JPA
    }

    public UserPO(String name, String imageUrl, String username, String email, String password, AddressPO address) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        creation_date = LocalDateTime.now();
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public AddressPO getAddress() {
        return address;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<AdvertisementPO> getAdvertisements() {
        return advertisements;
    }

    public User toUser() {
        try {
            com.yellow.domain.Id id = new com.yellow.domain.Id(getId());
            Credentials cred = new Credentials(getUsername(), getEmail(), getPassword());
            return new User(id, getName(), getImageUrl(), cred, getAddress().toAddress());
        } catch (DomainValidationException e) {
            throw new InternalServerException(Sid.INTERNAL_SERVER_ERROR, e.getMessage(), e.getCause());
        }
    }
}
