package com.project.porsche.repository;

import com.project.porsche.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturnRoleByName(){
        Role role = new Role();
        role.setName("guest");
        entityManager.persist(role);
        entityManager.flush();

        Role found = roleRepository.findRoleByName(role.getName());

        assertThat(found)
                .isEqualTo(role);
    }
}