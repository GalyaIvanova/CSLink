package com.example.project.model.mappers;

import com.example.project.model.dto.CosmetologistDTO;
import com.example.project.model.entities.Cosmetologist;
import com.example.project.model.entities.Procedure;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CosmetologistAssembler {

    public CosmetologistDTO toCosmetologistDTO(Cosmetologist cosmetologist) {
        CosmetologistDTO dto = new CosmetologistDTO();
        dto.setId(cosmetologist.getId());
        dto.setName(cosmetologist.getName());
        dto.setPhoneNumber(cosmetologist.getPhoneNumber());
//        dto.setSpecialty(cosmetologist.getSpecialty());
//        dto.setYearsOfExperience(cosmetologist.getYearsOfExperience());
        List<Long> procedureIds = cosmetologist.getProcedures().stream()
                .map(Procedure::getId)
                .collect(Collectors.toList());
        dto.setProcedureIds(procedureIds);
        dto.setAvailability(cosmetologist.getAvailability());
        return dto;
    }

    public Cosmetologist toCosmetologistEntity(CosmetologistDTO dto) {
        Cosmetologist cosmetologist = new Cosmetologist();
        cosmetologist.setName(dto.getName());
        cosmetologist.setPhoneNumber(dto.getPhoneNumber());
//        cosmetologist.setSpecialty(dto.getSpecialty());
//        cosmetologist.setYearsOfExperience(dto.getYearsOfExperience());
        List<Procedure> procedures = new ArrayList<>();
        if(dto.getProcedureIds() != null) {
            for(Long procedureId : dto.getProcedureIds()) {
                Procedure procedure = new Procedure();
                procedure.setId(procedureId);
                procedures.add(procedure);
            }
        }
        cosmetologist.setProcedures(procedures);
        cosmetologist.setAvailability(dto.getAvailability());
        return cosmetologist;
    }
}
