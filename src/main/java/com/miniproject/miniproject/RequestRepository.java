package com.miniproject.miniproject;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT r FROM Request r WHERE CONCAT(r.id, ' ', r.branch, ' ', r.amount, ' ', r.datetime, ' ', r.description, ' ', r.name, ' ', r.status) LIKE %?1%")
    public Page<Request> findAll(String keyword, Pageable pageable);
}
