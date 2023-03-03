package com.example.project.controller.service;

import com.example.project.model.dto.ClientDTO;
import com.example.project.model.dto.CosmetologistDTO;
import com.example.project.model.dto.ProcedureDTO;
import com.example.project.model.entities.Client;
import com.example.project.model.entities.Cosmetologist;

import java.util.List;

public interface CosmetologistService {
        List<CosmetologistDTO> getAllCosmetologists();
        Cosmetologist getCosmetologistById(Long cosmetologistId);
        CosmetologistDTO createCosmetologist(CosmetologistDTO cosmetologistDTO);
        CosmetologistDTO updateCosmetologist(Long cosmetologistId, CosmetologistDTO cosmetologistDTO);
        void deleteCosmetologist(Long cosmetologistId);
        List<ClientDTO> getClientsForCosmetologist(Long cosmetologistId);
        void addClientToCosmetologist(Long cosmetologistId, Long clientId);
        void removeClientFromCosmetologist(Long cosmetologistId, Long clientId);
        List<ProcedureDTO> getProceduresForCosmetologist(Long cosmetologistId);
        Cosmetologist addProcedureToCosmetologist(Long cosmetologistId, Long procedureId);
        Cosmetologist removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId);
       // List<Client> getClientsForCosmetologist(Long cosmetologistId);
}
