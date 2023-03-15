package com.example.project._recactor.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cosmetologist_id")
    private Cosmetologist cosmetologists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Cosmetologist getCosmetologist() {
        return cosmetologists;
    }

    public void setCosmetologist(Cosmetologist cosmetologist) {
        this.cosmetologists=cosmetologist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price=price;
    }
}
