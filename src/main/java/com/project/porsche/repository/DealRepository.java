package com.project.porsche.repository;

import com.project.porsche.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DealRepository extends JpaRepository<Deal, Long> {
    @Modifying
    @Query("update Deal d set d.status = :status where d.id = :id")
    void changeStatus(@Param("status") String status, @Param("id") Long id);
}