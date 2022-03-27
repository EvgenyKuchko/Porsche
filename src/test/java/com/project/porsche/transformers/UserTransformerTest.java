package com.project.porsche.transformers;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.RoleUser;
import com.project.porsche.entity.User;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTransformerTest {

    private static final UserTransformer userTransformer = new UserTransformer();

    @Test
    public void shouldTransformUserToUserDto() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("eugene");
        user.setLastName("eugene");
        user.setAge(20);
        user.setLogin("eugene");
        user.setPassword("12345");
        user.setRoles(Collections.singleton(RoleUser.USER));

        UserDto userDtoExpected = userTransformer.transform(user);

        assertThat(user.getLogin())
                .isEqualTo(userDtoExpected.getLogin());
    }
}