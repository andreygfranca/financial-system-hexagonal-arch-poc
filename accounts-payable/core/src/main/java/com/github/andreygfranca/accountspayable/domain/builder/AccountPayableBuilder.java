package com.github.andreygfranca.accountspayable.domain.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.domain.AccountPayableType;
import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
public final class AccountPayableBuilder {
    private AccountPayable accountPayable;

    private AccountPayableBuilder() {
        accountPayable = new AccountPayable();
    }

    public static AccountPayableBuilder anAccountPayable() {
        return new AccountPayableBuilder();
    }

    public AccountPayableBuilder withId(UUID id) {
        accountPayable.setId(id);
        return this;
    }

    public AccountPayableBuilder withType(AccountPayableType type) {
        accountPayable.setType(type);
        return this;
    }

    public AccountPayableBuilder withValue(BigDecimal value) {
        accountPayable.setValue(value);
        return this;
    }

    public AccountPayableBuilder withMaturityDate(LocalDate maturityDate) {
        accountPayable.setMaturityDate(maturityDate);
        return this;
    }

    public AccountPayableBuilder withObservation(String observation) {
        accountPayable.setObservation(observation);
        return this;
    }

    public AccountPayableBuilder withSettlements(List<Settlement> settlements) {
        accountPayable.setSettlement(settlements);
        return this;
    }

    public AccountPayable build() {
        return accountPayable;
    }
}
