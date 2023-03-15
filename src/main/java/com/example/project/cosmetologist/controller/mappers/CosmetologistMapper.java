package com.example.project.cosmetologist.controller.mappers;

import com.example.project.cosmetologist.model.dto.CosmetologistDTO;
import com.example.project.cosmetologist.model.entity.Cosmetologist;

public interface CosmetologistMapper {
    CosmetologistDTO toCosmetologistDTO(Cosmetologist cosmetologist);

    Cosmetologist toCosmetologistEntity(CosmetologistDTO dto);
}
