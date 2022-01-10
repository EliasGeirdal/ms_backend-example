package com.yellow.resources;

import com.yellow.domain.*;
import com.yellow.domain.exception.DomainValidationException;
import com.yellow.resources.dto.advertisement.AdvertisementDTO;
import com.yellow.resources.dto.advertisement.CreateAdvertisementDTO;
import com.yellow.resources.dto.user.CreateUserDTO;
import com.yellow.resources.dto.user.UserCreationDateDTO;
import com.yellow.resources.dto.user.UserDTO;
import com.yellow.service.UserService;
import com.yellow.service.exception.BadRequestException;
import com.yellow.service.request.CreateAdvertisementRequest;
import com.yellow.service.request.CreateUserRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Path("/user")
public class UserResource {
    private UserService service;

    @Inject
    public UserResource(UserService service) {
        this.service = service;
    }

    //GET
    @GET
    public List<UserDTO> getUsers() {
        return service.getUsers().stream().map(Mapper::map).collect(Collectors.toList());
    }

    // POST
    @POST
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        try {
            Credentials cred = new Credentials(createUserDTO.getUsername(),
                    createUserDTO.getEmail(),
                    createUserDTO.getPassword());
            Address address = Mapper.map(createUserDTO.getAddress());
            return Mapper.map(service.createUser(new CreateUserRequest(createUserDTO.getName(),
                    createUserDTO.getImageUrl(),
                    cred,
                    address)));
        } catch (DomainValidationException e) {
            throw new BadRequestException(e.getSid(), e.getMessage(), e.getCause());
        }
    }

    @Path("/{id}/advertisement")
    @POST
    public AdvertisementDTO createAdvertisement(@PathParam("id") String userId,
                                                CreateAdvertisementDTO createAdvertisementDTO) {
        AdvertisementDetails details = createAdvertisementDTO.getDetails();
        CreateAdvertisementRequest req = new CreateAdvertisementRequest(details);
        return Mapper.map(service.addAdvertisement(req, new Id(userId)));
    }

    @Path("/{id}/advertisement")
    @GET
    public List<AdvertisementDTO> getAdvertisements(@PathParam("id") String userId) {
        return service.getAdvertisements(new Id(userId)).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Path("/{id}/date")
    @GET
    public UserCreationDateDTO getDate(@PathParam("id") String userId) {
        return new UserCreationDateDTO(service.getDate(new Id(userId)));
    }
}
