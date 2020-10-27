package com.github.andreygfranca.accountspayable.ports.out;

import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
public interface CreateSettlementPort {
    Settlement create(Settlement settlement);
}
