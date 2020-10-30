package com.github.andreygfranca.cashflow.adapters.broker.listeners;

import static com.github.andreygfranca.cashflow.core.domain.builder.EntryBuilder.anEntry;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.github.andreygfranca.cashflow.adapters.broker.BrokerConstants;
import com.github.andreygfranca.cashflow.adapters.broker.dto.SettlementDTO;
import com.github.andreygfranca.cashflow.core.domain.Classification;
import com.github.andreygfranca.cashflow.core.domain.Entry;
import com.github.andreygfranca.cashflow.core.services.EntryService;

/**
 * @author Andrey Franca 
 */
@Component
public class BrokerAccountPayableListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(BrokerAccountPayableListener.class);

    private final EntryService entryService;

    public BrokerAccountPayableListener(EntryService entryService) {
        this.entryService = entryService;
    }

    @RabbitListener(queues = BrokerConstants.SETTLE_ACCOUNT_PAYABLE)
    public void receive(@Payload SettlementDTO settlement) {
        LOGGER.info("Receiving settlement on cashflow with id {}", settlement);

        Entry entry = anEntry()
                .withClassification(Classification.ACCOUNT_PAYABLE)
                .withPaymentDate(LocalDateTime.now())
                .withEntryDate(LocalDateTime.now())
                .build();

        entryService.create(entry);
    }
}
