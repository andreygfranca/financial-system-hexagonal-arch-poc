package com.github.andreygfranca.accountspayable.ports.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
@Component
public class SettlementPublisher {

    private static final Logger log = LoggerFactory.getLogger(SettlementPublisher.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${messaging.cash-flow.exchange}")
    private String exchange;

    @Value("${messaging.cash-flow.routingkey}")
    private String routingKey;

    public void send(Settlement settlement) {
        log.info("## Sending message to {} with {} and settlementId = {}",
                exchange, routingKey, settlement.getId().toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, settlement);
    }
}
