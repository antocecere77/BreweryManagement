package com.antocecere77.msscbeerservice.repositories;

import com.antocecere77.msscbeerservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
