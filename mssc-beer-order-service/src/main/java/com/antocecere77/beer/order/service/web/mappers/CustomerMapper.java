package com.antocecere77.beer.order.service.web.mappers;

import com.antocecere77.beer.order.service.domain.Customer;
import com.antocecere77.brewery.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {

    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(CustomerDto dto);
}