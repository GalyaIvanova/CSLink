package com.example.project._recactor.model.mappers;


import com.example.project._recactor.controller.service.CosmetologistService;
import com.example.project._useless.dto.ProcedureDTO;
import com.example.project._recactor.model.entities.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureAssembler {
    @Autowired
    private CosmetologistService cosmetologistService;

    public ProcedureDTO toProcedureDTO(Procedure procedure) {
        ProcedureDTO dto=new ProcedureDTO();
        dto.setId(procedure.getId());
        dto.setCosmetologistId(procedure.getCosmetologist().getId());
        dto.setName(procedure.getName());
        dto.setDescription(procedure.getDescription());
        dto.setPrice(procedure.getPrice());
        return dto;
    }

    public Procedure toProcedureEntity(ProcedureDTO dto) {
        Procedure procedure=new Procedure();
        procedure.setId(dto.getId());
        procedure.setCosmetologist(cosmetologistService.getCosmetologistById(dto.getCosmetologistId()));
        procedure.setName(dto.getName());
        procedure.setDescription(dto.getDescription());
        procedure.setPrice(dto.getPrice());
        return procedure;
    }
}


