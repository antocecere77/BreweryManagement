package com.antocecere77.msscbrewery.services;

import com.antocecere77.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
}
