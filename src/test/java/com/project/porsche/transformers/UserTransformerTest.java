//package com.project.porsche.transformers;
//
//import com.project.porsche.dto.UserDto;
//import com.project.porsche.entity.Role;
//import com.project.porsche.entity.User;
//import org.junit.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class UserTransformerTest {
//
//    private static final UserTransformer userTransformer = new UserTransformer();
//
//    @Test
//    public void shouldTransformUserToUserDto() {
//        User user = new User();
//        user.setId(1L);
//        user.setFirstName("eugene");
//        user.setLastName("eugene");
//        user.setAge(20);
//        user.setLogin("eugene");
//        user.setPassword("12345");
//        Set<User> users = new HashSet<>();
//        users.add(user);
//        Role admin = new Role(1,"admin", users);
//        Set<Role> roles = new HashSet<>();
//        roles.add(admin);
//        user.setRoles(roles);
//
//        UserDto userDto = userTransformer.transform(user);
//
//        assertThat(user.getLogin())
//                .isEqualTo(userDto.getLogin());
//    }
//}