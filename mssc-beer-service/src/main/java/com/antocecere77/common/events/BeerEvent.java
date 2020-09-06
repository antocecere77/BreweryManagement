package com.antocecere77.common.events;

import com.antocecere77.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -6717312292094129208L;

    private BeerDto beerDto;
}
