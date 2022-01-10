package com.yellow.resources;

import com.yellow.domain.Category;
import com.yellow.domain.Id;
import com.yellow.domain.Type;
import com.yellow.resources.dto.advertisement.AdvertisementCreationDateDTO;
import com.yellow.resources.dto.advertisement.AdvertisementDTO;
import com.yellow.resources.dto.advertisement.CreateAdvertisementDTO;
import com.yellow.resources.dto.advertisement.GetAdvertisementDTO;
import com.yellow.resources.dto.user.UserCreationDateDTO;
import com.yellow.service.AdvertisementService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/advertisement")
public class AdvertisementResource {

    private AdvertisementService service;

    @Inject
    public AdvertisementResource(AdvertisementService service) {
        this.service = service;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AdvertisementDTO getAdvertisement(@PathParam("id") String id) {
        return Mapper.map(service.getAdvertisement(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdvertisementDTO> getAdvertisements(@QueryParam("category") String category,
                                                    @QueryParam("type") String type,
                                                    @QueryParam("mobile") String mobile) {
        Category categoryParam = category == null ? null : Category.valueOf(category);
        Type typeParam = type == null ? null : Type.valueOf(type);
        return service.getAdvertisements(categoryParam, typeParam)
                .stream().map(Mapper::map)
                .collect(Collectors.toList());
    }

    @Path("/{id}/date")
    @GET
    public AdvertisementCreationDateDTO getDate(@PathParam("id") String advertisementId) {
        return new AdvertisementCreationDateDTO(service.getDate(new Id(advertisementId)));
    }
}
