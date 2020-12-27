package ru.itis.hateoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoas.models.MyProfile;
import ru.itis.hateoas.repositories.MyProfileRepository;

@Service
public class MyProfileServiceImpl implements MyProfileService {

    @Autowired
    private MyProfileRepository myProfileRepository;

    @Override
    public MyProfile getUserProfile(Long userId) {
        return myProfileRepository.findProfileByUserId(userId).get();
    }
}
