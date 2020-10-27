package com.github.andreygfranca.accountspayable.ports.usecase;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.ports.repository.AccountPayableRepository;
import com.github.andreygfranca.usecase.commons.UseCase;

/**
 * Create a new {@link AccountPayable} validating the necessary attributes
 *
 * @author Andrey Franca 
 */
@Component
@Transactional
public class CreateAccountPayableUseCase implements UseCase<AccountPayable> {

    private AccountPayableRepository accountPayableRepository;

    public CreateAccountPayableUseCase(AccountPayableRepository accountPayableRepository) {
        this.accountPayableRepository = accountPayableRepository;
    }

    @Override
    public AccountPayable execute(AccountPayable accountPayable) {
        return accountPayableRepository.save(accountPayable);
    }
}
