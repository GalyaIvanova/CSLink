package com.example.project.model.dao;

import com.example.project.model.entities.Cosmetologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmetologistRepository extends JpaRepository<Cosmetologist, Long> {
    List<Cosmetologist> findAll();
    Cosmetologist findByid(Long id);
    Cosmetologist save(Cosmetologist cosmetologist);
    void delete(long id);
}
