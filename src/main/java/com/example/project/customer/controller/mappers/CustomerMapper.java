package com.example.project.customer.controller.mappers;

import org.springframework.stereotype.Component;

import com.example.project.customer.model.dto.CustomerDTO;
import com.example.project.customer.model.entity.Customer;
@Component
public interface CustomerMapper {
    CustomerDTO toDtoModel(Customer client);

    Customer toClientEntity(CustomerDTO clientDTO);
}
