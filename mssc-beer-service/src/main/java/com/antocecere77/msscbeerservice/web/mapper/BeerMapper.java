package com.antocecere77.msscbeerservice.web.mapper;

import com.antocecere77.msscbeerservice.domain.Beer;
import com.antocecere77.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}