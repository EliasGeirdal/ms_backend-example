package com.yellow.service.request;

import com.yellow.domain.AdvertisementDetails;
import com.yellow.domain.Category;
import com.yellow.domain.Type;

public class CreateAdvertisementRequest {

    private AdvertisementDetails details;

    public CreateAdvertisementRequest(AdvertisementDetails details) {
        this.details = details;
    }

    public AdvertisementDetails getDetails() {
        return details;
    }
}
