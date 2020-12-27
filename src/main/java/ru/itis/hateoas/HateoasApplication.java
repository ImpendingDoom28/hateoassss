package ru.itis.hateoas;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.models.MyProfile;
import ru.itis.hateoas.models.User;
import ru.itis.hateoas.repositories.MyProfileRepository;
import ru.itis.hateoas.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication()
public class HateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateoasApplication.class);
    }

}
