package com.antocecere77.beer.order.service.services;

import com.antocecere77.brewery.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerPagedList listCustomers(Pageable pageable);
}
