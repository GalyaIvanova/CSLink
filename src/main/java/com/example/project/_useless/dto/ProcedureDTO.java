package com.example.project._useless.dto;

import java.math.BigDecimal;

public class ProcedureDTO {
    private Long id;
    private Long cosmetologistId;
    private String name;
    private String description;
    private BigDecimal price;
    //private Set<String> tags;


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

//    public List<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<String> tags) {
//        this.tags=tags;
//    }

    public Long getCosmetologistId() {
        return cosmetologistId;
    }

    public void setCosmetologistId(Long cosmetologistId) {
        this.cosmetologistId=cosmetologistId;
    }
}

