package com.antocecere77.msscbeerservice.services;

import com.antocecere77.msscbeerservice.domain.Beer;
import com.antocecere77.msscbeerservice.repositories.BeerRepository;
import com.antocecere77.msscbeerservice.web.controller.NotFoundException;
import com.antocecere77.msscbeerservice.web.mapper.BeerMapper;
import com.antocecere77.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public List<BeerDto> findAll() {
        List<BeerDto> result = new ArrayList<>();

        beerRepository.findAll().forEach(x -> result.add(beerMapper.beerToBeerDto(x)));;
        return result;
    }

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
