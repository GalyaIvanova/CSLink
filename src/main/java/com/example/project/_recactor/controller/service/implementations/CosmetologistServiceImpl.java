package com.example.project._recactor.controller.service.implementations;

import com.example.project._recactor.controller.service.CosmetologistService;
import com.example.project._recactor.model.data.exceptions.CustomBadRequestException;
import com.example.project._recactor.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project._recactor.model.dao.ClientRepository;
import com.example.project._recactor.model.dao.CosmetologistRepository;
import com.example.project._recactor.model.dao.ProcedureRepository;
import com.example.project._recactor.model.dao.ReservationRepository;
import com.example.project._useless.dto.ClientDTO;
import com.example.project._useless.dto.CosmetologistDTO;
import com.example.project._useless.dto.ProcedureDTO;
import com.example.project._recactor.model.entities.Client;
import com.example.project._recactor.model.entities.Cosmetologist;
import com.example.project._recactor.model.entities.Procedure;

import com.example.project._recactor.model.entities.Reservation;
import com.example.project._recactor.model.mappers.ClientAssembler;
import com.example.project._recactor.model.mappers.CosmetologistAssembler;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CosmetologistServiceImpl implements CosmetologistService {

    @Autowired
    private CosmetologistRepository cosmetologistRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ProcedureRepository procedureRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CosmetologistAssembler cosmetologistAssembler;
    @Autowired
    private ClientAssembler clientAssembler;

//    @Autowired
//    private ProcedureAssembler procedureAssembler;


//    @Autowired
//    public CosmetologistServiceImpl(CosmetologistRepository cosmetologistRepository, ReservationRepository reservationRepository, ProcedureRepository procedureRepository) {
//        this.cosmetologistRepository = cosmetologistRepository;
//        this.reservationRepository = reservationRepository;
//        this.procedureRepository = procedureRepository;
//    }

    @Override
    public List<CosmetologistDTO> getAllCosmetologists() {
        List<Cosmetologist> cosmetologists=cosmetologistRepository.findAll();
        return cosmetologists.stream()
                .map(cosmetologistAssembler::toCosmetologistDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Cosmetologist getCosmetologistById(Long id) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", id));
//        return convertToDto(cosmetologist);
        return cosmetologist;
    }

    @Override
    public CosmetologistDTO createCosmetologist(CosmetologistDTO cosmetologistDTO) {
        Cosmetologist cosmetologist=cosmetologistAssembler.toCosmetologistEntity(cosmetologistDTO);
        Cosmetologist savedCosmetologist=cosmetologistRepository.save(cosmetologist);
        return cosmetologistAssembler.toCosmetologistDTO(savedCosmetologist);
    }

    @Override
    public CosmetologistDTO updateCosmetologist(Long id, CosmetologistDTO cosmetologistDTO) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", id));

        Cosmetologist updatedCosmetologist=cosmetologistRepository.save(cosmetologist);
        return cosmetologistAssembler.toCosmetologistDTO(updatedCosmetologist);
    }

    @Override
    public void deleteCosmetologist(Long id) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", id));

        List<Reservation> reservations=reservationRepository.findByCosmetologist(cosmetologist);
        for (Reservation reservation : reservations) {
            reservation.setCosmetologist(null);
            reservationRepository.save(reservation);
        }

        cosmetologistRepository.delete(cosmetologist);
    }

    @Override
    public List<ClientDTO> getClientsForCosmetologist(Long cosmetologistId) {
        List<Client> clients=cosmetologistRepository.getClientsForCosmetologist(cosmetologistId);
        return clients.stream()
                .map(clientAssembler::toClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addClientToCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        Client client=clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Client", clientId));

        cosmetologist.addClient(client);
        cosmetologistRepository.save(cosmetologist);
    }

    @Override
    public void removeClientFromCosmetologist(Long cosmetologistId, Long clientId) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Client", clientId));

        cosmetologist.removeClient(clientId);
        cosmetologistRepository.save(cosmetologist);
    }

    @Override
    public Cosmetologist removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        procedureRepository.findById(procedureId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Procedure", procedureId));

        cosmetologist.removeProcedure(procedureId);
        return cosmetologistRepository.save(cosmetologist);
    }

    //todo
    @Override
    public List<ProcedureDTO> getProceduresForCosmetologist(Long cosmetologistId) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));
        return procedureRepository.findByCosmetologists(cosmetologist);
    }

    @Override
    public Cosmetologist addProcedureToCosmetologist(Long cosmetologistId, Long procedureId) {
        Cosmetologist cosmetologist=cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        Procedure procedure=procedureRepository.findById(procedureId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Procedure", procedureId));

        if (cosmetologist.getProcedures().contains(procedure)) {
            throw new CustomBadRequestException("Cosmetologist already has this procedure");
        }

        cosmetologist.addProcedure(procedure);
        return cosmetologistRepository.save(cosmetologist);
    }

//    @Override
//    public Cosmetologist saveCosmetologist(Cosmetologist cosmetologist) {
//        return cosmetologistRepository.save(cosmetologist);
//    }
//
//    @Override
//    public List<Cosmetologist> getAllCosmetologists() {
//        return cosmetologistRepository.findAll();
//    }
//
//    @Override
//    public Cosmetologist getCosmetologistById(Long id) {
//        return cosmetologistRepository.findById(id)
//                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", id));
//    }
//
//    @Override
//    public CosmetologistDTO createCosmetologist(CosmetologistDTO cosmetologistDTO) {
//        return null;
//    }
//
//    @Override
//    public CosmetologistDTO updateCosmetologist(Long cosmetologistId, CosmetologistDTO cosmetologistDTO) {
//        return null;
//    }
//
//    @Override
//    public void deleteCosmetologist(Long cosmetologistId) {
//
//    }
//
//    @Override
//    public void deleteCosmetologistById(Long id) {
//        cosmetologistRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Procedure> getProceduresForCosmetologist(Long cosmetologistId) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        return cosmetologist.getProcedures();
//    }
//
//    @Override
//    public void addProcedureToCosmetologist(Long cosmetologistId, Long procedureId) {
//
//    }
//
//    @Override
//    public void addProcedureToCosmetologist(Long cosmetologistId, Procedure procedure) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        List<Procedure> procedures = cosmetologist.getProcedures();
//        procedures.add(procedure);
//        cosmetologistRepository.save(cosmetologist);
//    }
//
//    @Override
//    public void removeProcedureFromCosmetologist(Long cosmetologistId, Long procedureId) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        List<Procedure> procedures = cosmetologist.getProcedures();
//        procedures.removeIf(procedure -> procedure.getId().equals(procedureId));
//        cosmetologistRepository.save(cosmetologist);
//    }
//
//    @Override
//    public Set<Client> getClientsForCosmetologist(Long cosmetologistId) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        return cosmetologist.getClients();
//    }
//
//    @Override
//    public void addClientToCosmetologist(Long cosmetologistId, Long clientId) {
//
//    }
//
//    @Override
//    public void addClientToCosmetologist(Long cosmetologistId, Client client) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        List<Client> clients = cosmetologist.getClients();
//        clients.add(client);
//        cosmetologistRepository.save(cosmetologist);
//    }
//
//    @Override
//    public void removeClientFromCosmetologist(Long cosmetologistId, Long clientId) {
//        Cosmetologist cosmetologist = getCosmetologistById(cosmetologistId);
//        List<Client> clients = cosmetologist.getClients();
//        clients.removeIf(client -> client.getId().equals(clientId));
//        cosmetologistRepository.save(cosmetologist);
//    }
}

