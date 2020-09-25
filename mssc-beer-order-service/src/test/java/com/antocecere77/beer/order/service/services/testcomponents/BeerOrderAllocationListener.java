package com.antocecere77.beer.order.service.services.testcomponents;

import com.antocecere77.beer.order.service.config.JmsConfig;
import com.antocecere77.brewery.model.events.AllocateOrderRequest;
import com.antocecere77.brewery.model.events.AllocateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderAllocationListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(Message msg){
        AllocateOrderRequest request = (AllocateOrderRequest) msg.getPayload();
        boolean pendingInventory = false;
        boolean allocationError = false;

        //set pending inventory
        if (request.getBeerOrderDto().getCustomerRef() != null && request.getBeerOrderDto().getCustomerRef().equals("partial-allocation")){
            pendingInventory = true;
        }

        //set allocation error
        if (request.getBeerOrderDto().getCustomerRef() != null && request.getBeerOrderDto().getCustomerRef().equals("fail-allocation")){
            allocationError = true;
        }

        boolean finalPendingInventory = pendingInventory;

        request.getBeerOrderDto().getBeerOrderLines().forEach(beerOrderLineDto -> {
            beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
            if (finalPendingInventory) {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity() - 1);
            } else {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
            }
        });

        System.out.println("########### I RAN BeerOrderAllocationListener ########");

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                AllocateOrderResult.builder()
                        .beerOrderDto(request.getBeerOrderDto())
                        .pendingInventory(pendingInventory)
                        .allocationError(allocationError)
                        .build());
    }
}