package com.example.project._useless._recactor.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project._useless._recactor.model.dao.tablespaces.CosmetologistRepositoryTableManger;
import com.example.project.cosmetologist.model.entity.Cosmetologist;
import com.example.project.customer.model.entity.Customer;
import com.example.project.procedure.model.Procedure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CosmetologistRepositoryImpl implements CosmetologistRepositoryTableManger {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getClientsForCosmetologist(Long cosmetologistId) {
        Query query=entityManager.createQuery("SELECT c FROM Cosmetologist co JOIN co.clients c WHERE co.id = :cosmetologistId");
        query.setParameter("cosmetologistId", cosmetologistId);
        return query.getResultList();
    }

    @Override
    public void addClientToCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Customer client=entityManager.find(Customer.class, clientId);
        cosmetologist.addClient(client);
    }

    @Override
    public void removeClientFromCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Customer client=entityManager.find(Customer.class, clientId);
        cosmetologist.removeClient(client.getId());
    }

    @Override
    public void addProcedureToCosmetologist(Long cosmetologistId, Long procedureId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Procedure procedure=entityManager.find(Procedure.class, procedureId);
        cosmetologist.addProcedure(procedure);
    }

    @Override
    public void removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Procedure procedure=entityManager.find(Procedure.class, procedureId);
        cosmetologist.removeProcedure(procedure.getId());
    }
}