package com.project.porsche.repository;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.Deal;
import com.project.porsche.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DealRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldChangeStatusOfDealById() {
        String status = "Failed";
        Car car = carRepository.getById(1L);
        User user = userRepository.findByLogin("qwerty");
        Deal deal = new Deal();
        deal.setUser(user);
        deal.setCar(car);
        deal.setPhoneNumber("+375290000000");
        deal.setCity("Minsk");
        deal.setCountry("Belarus");
        deal.setCreatingDate(new Timestamp(System.currentTimeMillis()));
        deal.setStatus("Active");
        entityManager.persist(deal);
        entityManager.flush();

        dealRepository.changeStatus(status, deal.getId());
        entityManager.refresh(deal);

        assertThat(deal.getStatus())
                .isEqualTo(status);
    }
}