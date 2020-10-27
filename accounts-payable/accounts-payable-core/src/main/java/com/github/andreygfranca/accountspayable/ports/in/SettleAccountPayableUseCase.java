package com.github.andreygfranca.accountspayable.ports.in;

import java.util.UUID;

import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
public interface SettleAccountPayableUseCase {
    Settlement settle(UUID accountPayableId, Settlement settlement);
}
