package com.github.andreygfranca.accountspayable.ports.out;

import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
public interface PublishSettlementToCashFlow {
    void publish(Settlement settlement);
}
