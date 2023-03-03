package com.example.project.controller;

import com.example.project.controller.service.ProcedureService;
import com.example.project.model.dto.ProcedureDTO;
import com.example.project.model.entities.Procedure;
import com.example.project.model.mappers.ProcedureAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @Autowired
    private ProcedureAssembler procedureAssembler;


    @GetMapping("/{id}")
    public ResponseEntity<ProcedureDTO> getProcedureById(@PathVariable("id") Long id) {
        ProcedureDTO procedure = procedureService.getProcedureById(id);
        return ResponseEntity.ok(procedure);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureDTO>> getAllProcedures() {
        List<ProcedureDTO> procedures = procedureService.getAllProcedures();
//        List<ProcedureDTO> procedureDTOs = procedures.stream()
//                .map(procedureAssembler::toProcedureDTO)
//                .collect(Collectors.toList());
        return ResponseEntity.ok(procedures);
    }

    @PostMapping("/create")
    public ResponseEntity<ProcedureDTO> createProcedure(@RequestBody ProcedureDTO procedureDTO) {
        ProcedureDTO createdProcedureDTO = procedureService.createProcedure(procedureDTO);
        return ResponseEntity.ok(createdProcedureDTO);
//        (createdProcedureDTO.getRequiredLink(IanaLinkRelations.SELF).toUri())
//                .body(createdProcedureDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedureDTO> updateProcedure(@PathVariable("id") Long id, @RequestBody ProcedureDTO procedureDTO) {
        ProcedureDTO updatedProcedureDTO = procedureService.updateProcedure(id, procedureDTO);
        return ResponseEntity.ok(updatedProcedureDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedure(@PathVariable("id") Long id) {
        procedureService.deleteProcedure(id);
        return ResponseEntity.noContent().build();
    }
}
