package com.project.porsche.repository;

import com.project.porsche.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        User user = User.builder()
                .firstName("eugene")
                .lastName("eugene")
                .age(20)
                .login("zzzzz")
                .password("12345")
                .build();
        entityManager.persist(user);
        entityManager.flush();
    }

    @Test
    public void shouldReturnUserByLogin(){
        String login = "zzzzz";

        User found = userRepository.findByLogin(login);

        assertThat(found.getLogin())
                .isEqualTo(login);
    }

    @Test
    public void shouldReturnTrueIfUserExistsByLogin(){
        String login = "zzzzz";

        assertThat(userRepository.existsByLogin(login))
                .isEqualTo(true);
    }
}