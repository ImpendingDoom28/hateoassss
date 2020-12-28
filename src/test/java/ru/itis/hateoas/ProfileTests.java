package ru.itis.hateoas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.hateoas.models.MyProfile;
import ru.itis.hateoas.models.Role;
import ru.itis.hateoas.models.User;
import ru.itis.hateoas.services.MyProfileService;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ProfileTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyProfileService profileService;

    private MyProfile myProfile() {
        return MyProfile.builder()
                .bio("Better than ever")
                .id(1L)
                .user(User.builder()
                    .createdAt(LocalDateTime.now())
                        .id(1L)
                        .role(Role.ADMIN)
                        .nickname("Sergey4ik")
                        .email("mikheevs11@gmail.com")
                        .build()
                )
                .build();
    }

    @BeforeEach
    public void setUp() {
        when(profileService.getUserProfile(1L)).thenReturn(myProfile());
    }

    @Test
    public void test_CorrectlyReturningProfile() throws Exception {
        mockMvc.perform(get("/myProfiles/users/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bio").value(myProfile().getBio()))
                .andExpect(jsonPath("$.user").value(myProfile().getUser()))
                .andDo(document("myProfile", responseFields(
                        fieldWithPath("bio").description("Биография владельца профиля"),
                        fieldWithPath("user").description("Владелец профиля")
                )));
    }
}
