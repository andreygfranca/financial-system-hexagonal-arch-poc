package com.github.andreygfranca.accountspayable.ports.out;

import java.util.Optional;
import java.util.UUID;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;

/**
 * @author Andrey Franca 
 */
public interface LoadAccountPayablePort {
    Optional<AccountPayable> load(UUID id);
}
