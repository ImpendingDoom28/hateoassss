package ru.itis.hateoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.hateoas.services.MyProfileService;

@RepositoryRestController
public class MyProfileController {

    @Autowired
    private MyProfileService myProfileService;

    @RequestMapping(value = "/myProfiles/users/{user-id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getProfileByUserId(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(EntityModel.of(myProfileService.getUserProfile(userId)));
    }


}
