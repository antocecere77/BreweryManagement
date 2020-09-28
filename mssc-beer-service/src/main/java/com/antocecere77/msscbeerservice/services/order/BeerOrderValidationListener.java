package com.antocecere77.msscbeerservice.services.order;

import com.antocecere77.brewery.model.events.ValidateOrderRequest;
import com.antocecere77.brewery.model.events.ValidateOrderResult;
import com.antocecere77.msscbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator validator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest) throws InterruptedException {
        Boolean isValid = validator.validateOrder(validateOrderRequest.getBeerOrder());
        Thread.sleep(500);

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(validateOrderRequest.getBeerOrder().getId())
                        .build());
    }
}