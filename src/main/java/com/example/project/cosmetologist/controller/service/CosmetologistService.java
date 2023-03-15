package com.example.project.cosmetologist.controller.service;

import java.util.List;

import com.example.project._useless.dto.ProcedureDTO;
import com.example.project.cosmetologist.model.dto.CosmetologistDTO;
import com.example.project.cosmetologist.model.entity.Cosmetologist;
import com.example.project.customer.model.dto.CustomerDTO;

public interface CosmetologistService {
    List<CosmetologistDTO> getAllCosmetologists();

    Cosmetologist getCosmetologistById(Long cosmetologistId);

    CosmetologistDTO createCosmetologist(CosmetologistDTO cosmetologistDTO);

    CosmetologistDTO updateCosmetologist(Long cosmetologistId, CosmetologistDTO cosmetologistDTO);

    void deleteCosmetologist(Long cosmetologistId);

    List<CustomerDTO> getCustomersForCosmetologist(Long cosmetologistId);

    void addCustomerToCosmetologist(Long cosmetologistId, Long CustomerId);

    List<ProcedureDTO> getProceduresForCosmetologist(Long cosmetologistId);

    Cosmetologist addProcedureToCosmetologist(Long cosmetologistId, Long procedureId);

    void removeCustomerFromCosmetologist(Long cosmetologistId, Long customerId);

    Cosmetologist removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId);
    // List<Customer> getCustomersForCosmetologist(Long cosmetologistId);
}
