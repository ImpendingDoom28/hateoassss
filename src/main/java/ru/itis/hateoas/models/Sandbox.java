package ru.itis.hateoas.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user"})
@Document(collection = "sandbox")
@Builder
public class Sandbox {
    @Id
    private String id;

    private String name;
    private String htmlCode;
    private String jsCode;
    private String cssCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
