package ru.itis.hateoas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoas.models.Sandbox;

import java.util.List;

public interface SandboxRepository extends MongoRepository<Sandbox, String> {

    @RestResource(path = "byCssOrJsCode", rel = "byCssOrJsCode")
    List<Sandbox> findByCssCodeOrOrJsCode(@Param("cssCode") String cssCode, @Param("jsCode") String jsCode);
}
