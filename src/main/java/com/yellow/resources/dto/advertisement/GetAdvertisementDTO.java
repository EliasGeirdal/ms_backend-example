package com.yellow.resources.dto.advertisement;


import com.yellow.domain.Category;
import com.yellow.domain.Type;

public class GetAdvertisementDTO {
    private Category category;
    private Type type;

    /**
     * Used to filter advertisements. If null is provided, it will return all.
     *
     * @param category
     * @param type
     */
    public GetAdvertisementDTO(Category category, Type type) {
        this.category = category;
        this.type = type;

    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

}
