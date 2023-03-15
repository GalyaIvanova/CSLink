package com.example.project.customer.model.dataccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.customer.model.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
}