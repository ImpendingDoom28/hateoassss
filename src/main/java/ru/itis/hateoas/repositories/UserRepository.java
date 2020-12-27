package ru.itis.hateoas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.itis.hateoas.models.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
