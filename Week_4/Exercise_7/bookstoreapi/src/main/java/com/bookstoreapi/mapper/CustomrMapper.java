package com.bookstoreapi.mapper;

import com.bookstoreapi.dto.CustomerDTO;
import com.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toCustomerDTO(Customer customer);
    Customer toCustomer(CustomerDTO customerDTO);
}
