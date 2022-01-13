package com.project.porsche.repository;

import com.project.porsche.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DealRepository extends JpaRepository<Deal, Long> {
    @Modifying
    @Query("update Deal d set d.status = ?1")
    void changeStatus(String status);
}