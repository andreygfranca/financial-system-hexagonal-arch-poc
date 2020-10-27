package com.github.andreygfranca.accountspayable.domain.builder;

import java.math.BigDecimal;
import java.util.UUID;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.domain.AccountPayableType;

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

    public AccountPayable build() {
        return accountPayable;
    }
}
