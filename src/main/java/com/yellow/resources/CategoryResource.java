package com.yellow.resources;

import com.yellow.domain.Advertisement;
import com.yellow.domain.Category;
import com.yellow.resources.dto.advertisement.CategoryDTO;
import com.yellow.resources.dto.advertisement.GetAdvertisementDTO;
import com.yellow.service.AdvertisementService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/categories")
public class CategoryResource {
    private AdvertisementService service;

    @Inject
    public CategoryResource(AdvertisementService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> getCategories() {
        List<Advertisement> ads = getAllAdvertisements();
        return Arrays.stream(Category.values())
                .map(c -> createCategoryDTO(c, ads))
                .collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{category}")
    public CategoryDTO getCategory(@PathParam("category") String category) {
        Category cat = Category.valueOf(category);
        return createCategoryDTO(cat, getAllAdvertisements());
    }

    private CategoryDTO createCategoryDTO(Category category, List<Advertisement> list) {
        return new CategoryDTO(category.name(), (int) list.stream().filter(ad -> ad.getAdvertisementDetails().getCategory() == category).count());
    }

    private List<Advertisement> getAllAdvertisements() {
        // return all advertisements with
        return service.getAdvertisements(null, null);
    }
}
