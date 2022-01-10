package com.yellow.service;

import com.yellow.domain.Advertisement;
import com.yellow.domain.Category;
import com.yellow.domain.Id;
import com.yellow.domain.Type;
import com.yellow.repository.Repository;
import com.yellow.resources.Mapper;
import com.yellow.resources.dto.advertisement.CreateAdvertisementDTO;
import com.yellow.resources.dto.advertisement.GetAdvertisementDTO;
import org.hibernate.boot.archive.scan.spi.ClassDescriptor;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Dependent
@Transactional
public class AdvertisementService {

    private final Repository repository;

    @Inject
    public AdvertisementService(Repository repository) {
        this.repository = repository;
    }

    public Advertisement getAdvertisement(String id) {
        return repository.getAdvertisementByID(new Id(id));
    }

    public List<Advertisement> getAdvertisements(Category category, Type type) {
        return repository.getAdvertisements(category, type);
    }

    public LocalDateTime getDate(Id id) {
        return repository.getAdvertisementDate(id);
    }
}