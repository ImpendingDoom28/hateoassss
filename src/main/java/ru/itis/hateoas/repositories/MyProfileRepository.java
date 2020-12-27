package ru.itis.hateoas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoas.models.MyProfile;
import ru.itis.hateoas.models.User;

import java.util.Optional;

@RepositoryRestResource
public interface MyProfileRepository extends PagingAndSortingRepository<MyProfile, Long> {

    @RestResource(path = "byUser", rel = "user")
    Optional<MyProfile> findProfileByUser(User user);

    @RestResource(path = "byUserId", rel="userId")
    Optional<MyProfile> findProfileByUserId(Long userId);
}