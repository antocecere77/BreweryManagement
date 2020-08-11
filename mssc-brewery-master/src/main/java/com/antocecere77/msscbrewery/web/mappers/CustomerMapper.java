package com.antocecere77.msscbrewery.web.mappers;

import com.antocecere77.msscbrewery.domain.Customer;
import com.antocecere77.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
