package com.yellow.resources;

import com.yellow.domain.*;
import com.yellow.repository.entities.AddressPO;
import com.yellow.repository.entities.AdvertisementPO;
import com.yellow.repository.entities.UserPO;
import com.yellow.resources.dto.advertisement.AdvertisementDTO;
import com.yellow.resources.dto.advertisement.AdvertisementDetailsDTO;
import com.yellow.resources.dto.advertisement.CreateAdvertisementDTO;
import com.yellow.resources.dto.user.AddressDTO;
import com.yellow.resources.dto.user.CreateUserDTO;
import com.yellow.resources.dto.user.UserDTO;

public class Mapper {

    public static Advertisement map(AdvertisementDTO advertisementDTO) {
        AdvertisementDetails details = new AdvertisementDetails(advertisementDTO.getDetails().getCategory(),
                advertisementDTO.getDetails().getType(),
                advertisementDTO.getDetails().getHeaderText(),
                advertisementDTO.getDetails().getText(),
                advertisementDTO.getDetails().getPrice(),
                advertisementDTO.getDetails().getImgUrl());
        return new Advertisement(advertisementDTO.getId(), details, map(advertisementDTO.getUser()));
    }

    public static AdvertisementDTO map(Advertisement advertisement) {
        AdvertisementDetailsDTO details = new AdvertisementDetailsDTO(advertisement.getAdvertisementDetails().getCategory(),
                advertisement.getAdvertisementDetails().getType(),
                advertisement.getAdvertisementDetails().getHeaderText(),
                advertisement.getAdvertisementDetails().getText(),
                advertisement.getAdvertisementDetails().getPrice(),
                advertisement.getAdvertisementDetails().getImgUrl());
        return new AdvertisementDTO(advertisement.getId(), details, map(advertisement.getUser()));
    }

    public static UserDTO map(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getImageUrl(), user.getCredentials(), user.getAddress());
    }

    public static User map(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getImageUrl(), userDTO.getCredentials(), userDTO.getAddress());
    }


    public static Address map(AddressDTO address) {
        return new Address(address.getCity(),
                address.getStreet(),
                address.getZipcode(),
                address.getStreet_number(),
                address.getFloor());
    }
}
