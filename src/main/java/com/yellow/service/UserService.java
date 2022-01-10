package com.yellow.service;

import com.yellow.domain.Advertisement;
import com.yellow.domain.Credentials;
import com.yellow.domain.Id;
import com.yellow.domain.User;
import com.yellow.repository.Repository;
import com.yellow.resources.Mapper;
import com.yellow.resources.dto.user.CreateUserDTO;
import com.yellow.resources.dto.user.UserCreationDateDTO;
import com.yellow.service.exception.NotFoundException;
import com.yellow.service.exception.Sid;
import com.yellow.service.request.CreateAdvertisementRequest;
import com.yellow.service.request.CreateUserRequest;
import org.hibernate.query.criteria.internal.predicate.NegatedPredicateWrapper;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Dependent
@Transactional
public class UserService {
    private final Repository repository;

    @Inject
    public UserService(Repository repository) {
        this.repository = repository;
    }

    public User createUser(CreateUserRequest createUserRequest) {
        return repository.createUser(createUserRequest.getName(), createUserRequest.getImageUrl(), createUserRequest.getCredentials(), createUserRequest.getAddress());
    }

    public Advertisement addAdvertisement(CreateAdvertisementRequest req, Id userId) {
        return repository.addAdvertisement(req.getDetails(), userId);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public List<Advertisement> getAdvertisements(Id userId) {
        return repository.getAdvertisementsForUser(userId);
    }

    public LocalDateTime getDate(Id id) {
        try {
            return repository.getUserDate(id);
        } catch (Exception e) {
            throw new NotFoundException(Sid.NO_USER_WITH_SPECIFIED_ID, e.getMessage(), e.getCause());
        }
    }
}
