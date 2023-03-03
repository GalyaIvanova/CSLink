package com.example.project.model.dao.tm;

import com.example.project.model.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public interface CosmetologistRepositoryTableManger{

    List<Client> getClientsForCosmetologist(Long cosmetologistId);

    void addClientToCosmetologist(Long cosmetologistId, Long clientId);

    void removeClientFromCosmetologist(Long cosmetologistId, Long clientId);

    void addProcedureToCosmetologist(Long cosmetologistId, Long procedureId);

    void removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId);
}