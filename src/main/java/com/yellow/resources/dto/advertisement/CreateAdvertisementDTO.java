package com.yellow.resources.dto.advertisement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yellow.domain.AdvertisementDetails;
import com.yellow.domain.Category;
import com.yellow.domain.Type;

public class CreateAdvertisementDTO {

    AdvertisementDetails details;

    @JsonCreator
    public CreateAdvertisementDTO(@JsonProperty("category") Category category,
                                  @JsonProperty("type") Type type,
                                  @JsonProperty("headerText") String headerText,
                                  @JsonProperty("text") String text,
                                  @JsonProperty("price") double price,
                                  @JsonProperty("imgUrl") String imgUrl) {
        details = new AdvertisementDetails(
                category, type, headerText, text, price, imgUrl
        );
    }

    public AdvertisementDetails getDetails() {
        return details;
    }
}
