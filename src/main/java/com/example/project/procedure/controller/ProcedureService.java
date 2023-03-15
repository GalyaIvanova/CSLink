package com.example.project.procedure.controller;

import java.util.List;

import com.example.project._useless.dto.ProcedureDTO;

public interface ProcedureService {

    ProcedureDTO createProcedure(ProcedureDTO procedureDTO);

    ProcedureDTO getProcedureById(Long id);

    List<ProcedureDTO> getAllProcedures();

    ProcedureDTO updateProcedure(Long id, ProcedureDTO procedureDTO);

    void deleteProcedure(Long id);

}
