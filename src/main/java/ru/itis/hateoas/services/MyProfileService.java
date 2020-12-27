package ru.itis.hateoas.services;

import ru.itis.hateoas.models.MyProfile;

public interface MyProfileService {

    MyProfile getUserProfile(Long userId);
}
