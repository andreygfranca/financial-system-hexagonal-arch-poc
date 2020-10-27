package com.github.andreygfranca.accountspayable.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.ports.out.CreateAccountPayablePort;
import com.github.andreygfranca.accountspayable.ports.out.LoadAccountPayablePort;

/**
 * @author Andrey Franca 
 */
@Component
public class AccountPayableRepository implements LoadAccountPayablePort, CreateAccountPayablePort {

    SpringDataAccountPayablePortRepository springDataAccountPayableRepository;

    public AccountPayableRepository(SpringDataAccountPayablePortRepository springDataAccountPayableRepository) {
        this.springDataAccountPayableRepository = springDataAccountPayableRepository;
    }

    @Override
    public Optional<AccountPayable> load(UUID id) {
        return springDataAccountPayableRepository.findById(id);
    }

    @Override
    public AccountPayable create(AccountPayable accountPayable) {
        return springDataAccountPayableRepository.save(accountPayable);
    }
}
