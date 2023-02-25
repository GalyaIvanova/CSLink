package com.example.project.controller;

import com.example.project.model.entities.Cosmetologist;
import com.example.project.model.dao.CosmetologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cosmetologists")
public class CosmetologistController {

    @Autowired
    private CosmetologistRepository cosmetologistRepository;

    @GetMapping
    public List<Cosmetologist> getCosmetologists() {
        return cosmetologistRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cosmetologist> getCosmetologistById(@PathVariable(value = "id") Long id) {
        Optional<Cosmetologist> cosmetologist = cosmetologistRepository.findById(id);
        if (cosmetologist.isPresent()) {
            return ResponseEntity.ok().body(cosmetologist.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Cosmetologist createCosmetologist(@RequestBody Cosmetologist cosmetologist) {
        return cosmetologistRepository.save(cosmetologist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cosmetologist> updateCosmetologist(@PathVariable(value = "id") Long id,
                                                             @RequestBody Cosmetologist cosmetologistDetails) {
        Optional<Cosmetologist> optionalCosmetologist = cosmetologistRepository.findById(id);
        if (optionalCosmetologist.isPresent()) {
            Cosmetologist cosmetologist = optionalCosmetologist.get();
            cosmetologist.setName(cosmetologistDetails.getName());
            Cosmetologist updatedCosmetologist = cosmetologistRepository.save(cosmetologist);
            return ResponseEntity.ok(updatedCosmetologist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCosmetologist(@PathVariable(value = "id") Long id) {
        Optional<Cosmetologist> cosmetologist = cosmetologistRepository.findById(id);
        if (cosmetologist.isPresent()) {
            cosmetologistRepository.delete(cosmetologist.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
