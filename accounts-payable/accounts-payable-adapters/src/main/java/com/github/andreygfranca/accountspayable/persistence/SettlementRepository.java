package com.github.andreygfranca.accountspayable.persistence;

import org.springframework.stereotype.Component;

import com.github.andreygfranca.accountspayable.domain.Settlement;
import com.github.andreygfranca.accountspayable.ports.out.CreateSettlementPort;

/**
 * @author Andrey Franca 
 */
@Component
public class SettlementRepository implements CreateSettlementPort {

    private SpringDataSettlementRepository springDataSettlementRepository;

    public SettlementRepository(SpringDataSettlementRepository springDataSettlementRepository) {
        this.springDataSettlementRepository = springDataSettlementRepository;
    }

    @Override
    public Settlement create(Settlement settlement) {
        return springDataSettlementRepository.save(settlement);
    }
}
