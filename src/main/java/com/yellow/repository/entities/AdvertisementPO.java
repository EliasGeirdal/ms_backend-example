package com.yellow.repository.entities;

import com.yellow.domain.AdvertisementDetails;
import com.yellow.domain.Category;
import com.yellow.domain.Advertisement;
import com.yellow.service.UserService;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Advertisement")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findByCategoryType", query = "Select a FROM AdvertisementPO a where :category is null or a.category= :category and :type is null or a.type=:type"),
})
public class AdvertisementPO {
    public static final String FIND_BY_CATEGORY_TYPE = "AdvertisementPO.findByCategoryType";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category", columnDefinition = "VARCHAR(40)")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", columnDefinition = "VARCHAR(40)")
    private com.yellow.domain.Type type;

    @Column(name = "HeaderText", columnDefinition = "VARCHAR(200)")
    private String headerText;

    @Column(name = "Text", columnDefinition = "VARCHAR(1000)")
    private String text;

    @Column(name = "Price", columnDefinition = "VARCHAR(1000)")
    private double price;

    @Column(name = "ImageURL", columnDefinition = "VARCHAR(40)")
    private String imgUrl;

    @Column(name = "creation_date", columnDefinition = "DATETIME")
    private LocalDateTime creation_date;

    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private UserPO user;

    public AdvertisementPO() {
        //JPA
    }

    public AdvertisementPO(AdvertisementDetails details, UserPO user) {
        this.category = details.getCategory();
        this.type = details.getType();
        this.headerText = details.getHeaderText();
        this.text = details.getText();
        this.price = details.getPrice();
        this.imgUrl = details.getImgUrl();
        this.user = user;
        creation_date = LocalDateTime.now();
    }

    public UserPO getUser() {
        return user;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public Category getCategory() {
        return category;
    }

    public com.yellow.domain.Type getType() {
        return type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getText() {
        return text;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public UUID getId() {
        return Id;
    }

    public Advertisement toAdvertisement() {
        return new Advertisement(new com.yellow.domain.Id(getId()), new AdvertisementDetails(getCategory(),
                getType(),
                getHeaderText(),
                getText(),
                getPrice(),
                getImgUrl()), user.toUser());
    }
}
