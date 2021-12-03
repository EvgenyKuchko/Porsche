package com.project.porsche.service;

import com.project.porsche.entity.Deal;
import com.project.porsche.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    @Transactional
    public boolean saveDeal(Deal deal){
        dealRepository.save(deal);
        return true;
    }

    @Transactional
    public List<Deal> getDeals(){
        return dealRepository.findAll();
    }

    @Transactional
    public Deal getDeal(Long id) {
        return dealRepository.getById(id);
    }
}
