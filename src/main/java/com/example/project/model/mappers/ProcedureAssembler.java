package com.example.project.model.mappers;


import com.example.project.model.dto.ProcedureDTO;
import com.example.project.model.entities.Procedure;
import org.springframework.stereotype.Component;

@Component
public class ProcedureAssembler {

    public ProcedureDTO toProcedureDTO(Procedure procedure) {
        ProcedureDTO dto=new ProcedureDTO();
        dto.setId(procedure.getId());
        dto.setName(procedure.getName());
        dto.setDescription(procedure.getDescription());
        dto.setPrice(procedure.getPrice());
        return dto;
    }

    public Procedure toProcedureEntity(ProcedureDTO dto) {
        Procedure procedure=new Procedure();
        procedure.setId(dto.getId());
        procedure.setName(dto.getName());
        procedure.setDescription(dto.getDescription());
        procedure.setPrice(dto.getPrice());
        return procedure;
    }
}


