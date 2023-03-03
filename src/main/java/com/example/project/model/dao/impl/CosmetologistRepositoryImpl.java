package com.example.project.model.dao.impl;

import com.example.project.model.dao.CosmetologistRepository;
import com.example.project.model.dao.tm.CosmetologistRepositoryTableManger;
import com.example.project.model.entities.Client;
import com.example.project.model.entities.Cosmetologist;
import com.example.project.model.entities.Procedure;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Transactional
public class CosmetologistRepositoryImpl implements CosmetologistRepositoryTableManger {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getClientsForCosmetologist(Long cosmetologistId) {
        Query query=entityManager.createQuery("SELECT c FROM Cosmetologist co JOIN co.clients c WHERE co.id = :cosmetologistId");
        query.setParameter("cosmetologistId", cosmetologistId);
        return query.getResultList();
    }

    @Override
    public void addClientToCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Client client=entityManager.find(Client.class, clientId);
        cosmetologist.addClient(client);
    }

    @Override
    public void removeClientFromCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=entityManager.find(Cosmetologist.class, cosmetologistId);
        Client client=entityManager.find(Client.class, clientId);
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