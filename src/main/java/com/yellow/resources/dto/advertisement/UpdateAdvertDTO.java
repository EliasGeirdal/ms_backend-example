package com.yellow.resources.dto.advertisement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yellow.domain.Category;
import com.yellow.domain.Type;

public class UpdateAdvertDTO {

    private Category category;
    private Type type;
    private String headerText;
    private String text;
    private double price;
    private String mobile;
    private String imgUrl;

    @JsonCreator
    public UpdateAdvertDTO(@JsonProperty("category") Category category,
                           @JsonProperty("type") Type type,
                           @JsonProperty("headerText") String headerText,
                           @JsonProperty("text") String text,
                           @JsonProperty("price") double price,
                           @JsonProperty("mobile") String mobile,
                           @JsonProperty("imgUrl") String imgUrl) {
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = text;
        this.price = price;
        this.mobile = mobile;
        this.imgUrl = imgUrl;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
