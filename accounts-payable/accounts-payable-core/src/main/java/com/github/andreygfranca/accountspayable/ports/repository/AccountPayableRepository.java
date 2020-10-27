package com.github.andreygfranca.accountspayable.ports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.andreygfranca.accountspayable.domain.AccountPayable;

/**
 * @author Andrey Franca 
 */
@Repository
public interface AccountPayableRepository extends JpaRepository<AccountPayable, String> {
}
