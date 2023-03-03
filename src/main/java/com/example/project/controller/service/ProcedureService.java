package com.example.project.controller.service;

import com.example.project.model.dto.ProcedureDTO;

import java.util.List;

public interface ProcedureService {

    ProcedureDTO createProcedure(ProcedureDTO procedureDTO);

    ProcedureDTO getProcedureById(Long id);

    List<ProcedureDTO> getAllProcedures();

    ProcedureDTO updateProcedure(Long id, ProcedureDTO procedureDTO);

    void deleteProcedure(Long id);

}
