package com.antocecere77.brewery.model.events;

import com.antocecere77.brewery.model.BeerDto;
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
