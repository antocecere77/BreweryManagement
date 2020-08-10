package com.antocecere77.msscbrewery.services;

import com.antocecere77.msscbrewery.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
