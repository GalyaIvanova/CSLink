package com.example.project._useless._recactor.model.dao.tablespaces;

import java.util.List;

import com.example.project.customer.model.entity.Customer;

public interface CosmetologistRepositoryTableManger{

    List<Customer> getClientsForCosmetologist(Long cosmetologistId);

    void addClientToCosmetologist(Long cosmetologistId, Long clientId);

    void removeClientFromCosmetologist(Long cosmetologistId, Long clientId);

    void addProcedureToCosmetologist(Long cosmetologistId, Long procedureId);

    void removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId);
}