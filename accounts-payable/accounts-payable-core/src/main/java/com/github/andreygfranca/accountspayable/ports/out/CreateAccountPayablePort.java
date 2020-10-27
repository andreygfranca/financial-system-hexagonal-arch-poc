package com.github.andreygfranca.accountspayable.ports.out;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;

/**
 * @author Andrey Franca 
 */
public interface CreateAccountPayablePort {
    AccountPayable create(AccountPayable accountPayable);
}
