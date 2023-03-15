package com.example.project.cosmetologist.model.dataccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.cosmetologist.model.entity.Cosmetologist;
import com.example.project.customer.model.entity.Customer;

@Repository
public interface CosmetologistDao extends JpaRepository<Cosmetologist, Long> {

    List<Customer> getCustomersForCosmetologist(Long cosmetologistId);
}
