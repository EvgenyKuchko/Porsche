package com.project.porsche.repository;

import com.project.porsche.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void shouldFindAndReturnCarByModel() {
        Car bmw = new Car();
        bmw.setModel("x5");
        entityManager.persist(bmw);
        entityManager.flush();

        Car found = carRepository.findByModel(bmw.getModel());

        assertThat(found)
                .isEqualTo(bmw);
    }
}