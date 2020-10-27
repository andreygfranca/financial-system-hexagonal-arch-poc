package com.github.andreygfranca.accountspayable.ports.usecase;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.domain.Settlement;
import com.github.andreygfranca.accountspayable.ports.publisher.SettlementPublisher;
import com.github.andreygfranca.accountspayable.ports.repository.AccountPayableRepository;
import com.github.andreygfranca.accountspayable.ports.repository.SettlementRepository;
import com.github.andreygfranca.usecase.commons.UseCase;

/**
 * @author Andrey Franca 
 */
@Component
@Transactional
public class SettleAccountPayableUseCase implements UseCase<Settlement> {

    private SettlementRepository settlementRepository;
    private SettlementPublisher settlementPublisher;
    private AccountPayableRepository accountPayableRepository;

    public SettleAccountPayableUseCase(SettlementRepository settlementRepository, SettlementPublisher settlementPublisher, AccountPayableRepository accountPayableRepository) {
        this.settlementRepository = settlementRepository;
        this.settlementPublisher = settlementPublisher;
        this.accountPayableRepository = accountPayableRepository;
    }

    public Settlement execute(Settlement settlement) {
        Optional<AccountPayable> accountPayableToSettle = accountPayableRepository
                .findById(settlement.getAccountPayable().getId());

        if (accountPayableToSettle.get().getMaturityDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("It is not possible to settle an account payable with an expired date.");
        }

        Settlement persistedSettlement = settlementRepository.save(settlement);

        settlementPublisher.send(persistedSettlement);

        return persistedSettlement;
    }
}
