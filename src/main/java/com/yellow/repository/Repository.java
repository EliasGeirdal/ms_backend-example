package com.yellow.repository;


import com.yellow.domain.*;
import com.yellow.repository.entities.AddressPO;
import com.yellow.repository.entities.AdvertisementPO;
import com.yellow.repository.entities.UserPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Repository {
    private final EntityManager entityManager;

    @Inject
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // ADVERTISEMENT
    public Advertisement getAdvertisementByID(Id id) {
        return entityManager.find(AdvertisementPO.class, id.getValue()).toAdvertisement();
    }

    public List<Advertisement> getAdvertisements(Category category, Type type) {
        try {
            TypedQuery<AdvertisementPO> query = entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY_TYPE, AdvertisementPO.class);
            query.setParameter("category", category);
            query.setParameter("type", type);
            return query.getResultList().stream().map(advertisement -> advertisement.toAdvertisement())
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

    public LocalDateTime getAdvertisementDate(Id advertisementId) {
        AdvertisementPO advertisementPO = entityManager.find(AdvertisementPO.class, advertisementId.getValue());
        return advertisementPO.getCreation_date();
    }

    //USER
    public User createUser(String name, String imageUrl, Credentials credentials, Address address) {
        UserPO userPO = new UserPO(name,
                imageUrl,
                credentials.getUsername(),
                credentials.getEmail(),
                credentials.getPassword(),
                new AddressPO(address.getCity(),
                        address.getStreet(),
                        "" + address.getZipcode(),
                        "" + address.getStreet_number(),
                        address.getFloor())
        );
        entityManager.persist(userPO);
        return userPO.toUser();
    }

    
    public List<User> getUsers() {
        try {
            return entityManager.createNamedQuery(UserPO.FIND_USERS, UserPO.class).getResultList().stream()
                    .map(UserPO::toUser)
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

    public Advertisement addAdvertisement(AdvertisementDetails details, Id userId) {
        UserPO userPO = entityManager.find(UserPO.class, userId.getValue());
        AdvertisementPO advertisementPO = new AdvertisementPO(details, userPO);
        entityManager.persist(advertisementPO);
        return advertisementPO.toAdvertisement();
    }

    public List<Advertisement> getAdvertisementsForUser(Id userId) {
        UserPO userPO = entityManager.find(UserPO.class, userId.getValue());
        return userPO.getAdvertisements().stream().map(advertisement -> advertisement.toAdvertisement()).collect(Collectors.toList());
    }

    public LocalDateTime getUserDate(Id userId) {
        UserPO userPO = entityManager.find(UserPO.class, userId.getValue());
        return userPO.getCreation_date();
    }
}