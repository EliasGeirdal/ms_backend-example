package com.yellow.resources.dto.advertisement;

import com.yellow.domain.Category;
import com.yellow.domain.Type;

public class AdvertisementDetailsDTO {
    private Category category;
    private Type type;
    private String headerText;
    private String text;
    private double price;
    private String imgUrl;

    public AdvertisementDetailsDTO(Category category, Type type, String headerText, String text, double price, String imgUrl) {
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = text;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
