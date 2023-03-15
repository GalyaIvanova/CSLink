package com.example.project._recactor.model.mappers;

import com.example.project.user.controller.service.UserProfileService;
import com.example.project._useless.dto.CosmetologistDTO;
import com.example.project._recactor.model.entities.Cosmetologist;
import com.example.project._recactor.model.entities.Procedure;
import com.example.project.user.controller.mapper.UserProfileMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CosmetologistAssembler {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserProfileMapper userProfileMapper;

    public CosmetologistDTO toCosmetologistDTO(Cosmetologist cosmetologist) {
        CosmetologistDTO dto=new CosmetologistDTO();
        dto.setId(cosmetologist.getId());
        dto.setUserProfileId(cosmetologist.getUserProfile().getId());
//        dto.setSpecialty(cosmetologist.getSpecialty());
//        dto.setYearsOfExperience(cosmetologist.getYearsOfExperience());
        List<Long> procedureIds=cosmetologist.getProcedures().stream()
                .map(Procedure::getId)
                .collect(Collectors.toList());
        dto.setProcedureIds(procedureIds);
        //dto.setAvailability(cosmetologist.getAvailability());
        return dto;
    }

    public Cosmetologist toCosmetologistEntity(CosmetologistDTO dto) {
        Cosmetologist cosmetologist=new Cosmetologist();
        cosmetologist.setId(cosmetologist.getId());
        cosmetologist.setUserProfile(userProfileMapper.toEntity(userProfileService.getUserProfileById(dto.getUserProfileId())));
//        cosmetologist.setSpecialty(dto.getSpecialty());
//        cosmetologist.setYearsOfExperience(dto.getYearsOfExperience());
        List<Procedure> procedures=new ArrayList<>();
        if (dto.getProcedureIds() != null) {
            for (Long procedureId : dto.getProcedureIds()) {
                Procedure procedure=new Procedure();
                procedure.setId(procedureId);
                procedures.add(procedure);
            }
        }
        cosmetologist.setProcedures(procedures);
       // cosmetologist.setAvailability(dto.getAvailability());
        return cosmetologist;
    }
}
