package com.antocecere77.msscbeerservice.services;

import com.antocecere77.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<BeerDto> findAll();

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
