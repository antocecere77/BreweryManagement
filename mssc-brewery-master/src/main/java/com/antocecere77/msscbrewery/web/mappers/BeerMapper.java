package com.antocecere77.msscbrewery.web.mappers;

import com.antocecere77.msscbrewery.domain.Beer;
import com.antocecere77.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
