package com.example.project._recactor.model.dao;

import com.example.project._recactor.model.entities.Client;
import com.example.project._recactor.model.entities.Cosmetologist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmetologistRepository extends JpaRepository<Cosmetologist, Long> {
    List<Client> getClientsForCosmetologist(Long cosmetologistId);
}
