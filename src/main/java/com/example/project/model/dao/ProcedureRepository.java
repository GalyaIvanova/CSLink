package com.example.project.model.dao;

import com.example.project.model.entities.Cosmetologist;
import com.example.project.model.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    List<Procedure> findByCosmetologists(Cosmetologist cosmetologist);
}