package com.github.andreygfranca.accountspayable.broker.publishers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.andreygfranca.accountspayable.domain.Settlement;
import com.github.andreygfranca.accountspayable.broker.dto.SettlementDTO;
import com.github.andreygfranca.accountspayable.ports.out.PublishSettlementToCashFlow;

/**
 * @author Andrey Franca 
 */
@Component
public class CashFlowPublisher implements PublishSettlementToCashFlow {

    private static final Logger log = LoggerFactory.getLogger(CashFlowPublisher.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${messaging.cash-flow.exchange}")
    private String exchange;

    @Value("${messaging.cash-flow.routingkey}")
    private String routingKey;

    public CashFlowPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(Settlement settlement) {
        SettlementDTO settlementDTO = SettlementDTO.Builder.of()
                .id(settlement.getId().toString())
                .value(settlement.getValue())
                .accountPayableId(settlement.getAccountPayable().getId().toString())
                .build();

        log.info("Sending message to {} with {} and settlementId = {}",
                exchange, routingKey, settlementDTO.getId());

        rabbitTemplate.convertAndSend(exchange, routingKey, settlementDTO);
    }
}
