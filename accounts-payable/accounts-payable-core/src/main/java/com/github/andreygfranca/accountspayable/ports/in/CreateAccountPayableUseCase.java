package com.github.andreygfranca.accountspayable.ports.in;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;

/**
 * @author Andrey Franca 
 */
public interface CreateAccountPayableUseCase {
    AccountPayable create(AccountPayable accountPayable);
}
