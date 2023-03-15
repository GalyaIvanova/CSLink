package com.example.project.procedure.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project._useless.dto.ProcedureDTO;
import com.example.project.cosmetologist.model.entity.Cosmetologist;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    List<ProcedureDTO> findByCosmetologists(Cosmetologist cosmetologist);
}