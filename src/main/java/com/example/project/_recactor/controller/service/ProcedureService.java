package com.example.project._recactor.controller.service;

import com.example.project._useless.dto.ProcedureDTO;

import java.util.List;

public interface ProcedureService {

    ProcedureDTO createProcedure(ProcedureDTO procedureDTO);

    ProcedureDTO getProcedureById(Long id);

    List<ProcedureDTO> getAllProcedures();

    ProcedureDTO updateProcedure(Long id, ProcedureDTO procedureDTO);

    void deleteProcedure(Long id);

}
