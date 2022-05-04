package com.project.porsche.service;

import com.project.porsche.dto.DealDto;
import com.project.porsche.dto.DealRequestDto;
import com.project.porsche.entity.Car;
import com.project.porsche.entity.Deal;
import com.project.porsche.entity.User;
import com.project.porsche.repository.CarRepository;
import com.project.porsche.repository.DealRepository;
import com.project.porsche.repository.UserRepository;
import com.project.porsche.transformers.DealTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {

    @InjectMocks
    private DealService dealService;
    @Mock
    private DealRepository dealRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private DealTransformer dealTransformer;

    @Test
    void shouldReturnDealById() {
        Deal deal = new Deal();
        deal.setId(1L);

        when(dealRepository.getById(deal.getId())).thenReturn(deal);

        assertThat(dealService.getDeal(deal.getId())).isEqualTo(dealTransformer.transform(deal));
    }

    @Test
    void shouldReturnAllDeals() {
        Deal dealOne = new Deal();
        Deal dealTwo = new Deal();
        List<Deal> deals = new ArrayList<>();
        deals.add(dealOne);
        deals.add(dealTwo);

        when(dealRepository.findAll()).thenReturn(deals);

        List<DealDto> dtoDeals = dealService.getDeals();

        assertThat(deals.size()).isEqualTo(dtoDeals.size());
    }

    @Test
    void shouldSaveNewDeal() {
        Deal deal = new Deal();
        String model = "911";
        Car car = new Car();
        UserDetails userDetails = new User();
        User user = new User();
        DealRequestDto dealRequestDto = new DealRequestDto();
        dealRequestDto.setCity("London");
        dealRequestDto.setCountry("Great Britain");
        dealRequestDto.setPhoneNumber("+123557896542");
        deal.setStatus("Active");
        deal.setCar(car);
        deal.setUser(user);
        deal.setCountry(dealRequestDto.getCountry());
        deal.setCity(dealRequestDto.getCity());
        deal.setPhoneNumber(dealRequestDto.getPhoneNumber());

        when(carRepository.findByModel(model)).thenReturn(car);
        when(userRepository.findByLogin(userDetails.getUsername())).thenReturn(user);
        lenient().when(dealRepository.save(deal)).thenReturn(deal);

        dealService.saveDeal(dealRequestDto, model, userDetails);

        verify(carRepository, times(1)).findByModel(model);
        verify(userRepository, times(1)).findByLogin(userDetails.getUsername());
        ArgumentCaptor<Deal> captor = ArgumentCaptor.forClass(Deal.class);  // создается объект захватчика Deal класса
        verify(dealRepository).save(captor.capture());   // захват объекта deal
        Deal value = captor.getValue();  // сохранение в объект захваченной переменной
        assertThat(value.getStatus()).isEqualTo(deal.getStatus());
        assertThat(value.getCountry()).isEqualTo(deal.getCountry());
        assertThat(value.getCity()).isEqualTo(deal.getCity());
        assertThat(value.getPhoneNumber()).isEqualTo(deal.getPhoneNumber());
        assertThat(value.getUser()).isEqualTo(deal.getUser());
        assertThat(value.getCar()).isEqualTo(deal.getCar());
    }

    @Test
    void shouldReturnUpdatedDeal() {
        dealService.update(anyString(), anyLong());

        verify(dealRepository, times(1)).changeStatus(anyString(), anyLong());
    }
}