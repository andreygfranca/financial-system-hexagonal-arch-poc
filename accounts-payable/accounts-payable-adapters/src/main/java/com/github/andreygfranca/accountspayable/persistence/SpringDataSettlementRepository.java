package com.github.andreygfranca.accountspayable.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.andreygfranca.accountspayable.domain.Settlement;

/**
 * @author Andrey Franca 
 */
@Repository
public interface SpringDataSettlementRepository extends JpaRepository<Settlement, UUID> {
}
