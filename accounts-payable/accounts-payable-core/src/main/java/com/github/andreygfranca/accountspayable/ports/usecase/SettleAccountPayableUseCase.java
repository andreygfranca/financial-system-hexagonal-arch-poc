package com.github.andreygfranca.accountspayable.ports.usecase;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.domain.Settlement;
import com.github.andreygfranca.accountspayable.ports.publisher.SettlementPublisher;
import com.github.andreygfranca.accountspayable.ports.repository.SettlementRepository;
import com.github.andreygfranca.usecase.commons.UseCase;

/**
 * @author Andrey Franca 
 */
@Component
@Transactional
public class SettleAccountPayableUseCase implements UseCase<Settlement> {

    private SettlementRepository repository;
    private SettlementPublisher settlementPublisher;

    public SettleAccountPayableUseCase(SettlementRepository repository, SettlementPublisher settlementPublisher) {
        this.repository = repository;
        this.settlementPublisher = settlementPublisher;
    }

    public Settlement execute(Settlement settlement) {
        AccountPayable accountPayableToSettle = settlement.getAccountPayable();

        if (accountPayableToSettle.getMaturityDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("It is not possible to settle an account payable with an expired date.");
        }

        Settlement persistedSettlement = repository.save(settlement);

        settlementPublisher.send(persistedSettlement);

        return persistedSettlement;
    }
}
