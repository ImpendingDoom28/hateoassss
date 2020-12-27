package ru.itis.hateoas.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.hateoas.controllers.MyProfileController;
import ru.itis.hateoas.models.MyProfile;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProfileRepresentationProcessor implements RepresentationModelProcessor<EntityModel<MyProfile>> {

    @Override
    public EntityModel<MyProfile> process(EntityModel<MyProfile> model) {
        MyProfile myProfile = model.getContent();
        if (myProfile != null) {
            model.add(linkTo(methodOn(MyProfileController.class)
            .getProfileByUserId(myProfile.getUser().getId())).withRel("profileByUserId"));
        }
        return model;
    }
}
