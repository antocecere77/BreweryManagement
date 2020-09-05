package com.antocecere77.msscbeerservice.events;

import com.antocecere77.msscbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -6717312292094129208L;

    private final BeerDto beerDto;
}
