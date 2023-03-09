package com.example.project._recactor.model.dao;

import com.example.project._recactor.model.entities.Cosmetologist;
import com.example.project._recactor.model.entities.Procedure;
import com.example.project._useless.dto.ProcedureDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    List<ProcedureDTO> findByCosmetologists(Cosmetologist cosmetologist);
}