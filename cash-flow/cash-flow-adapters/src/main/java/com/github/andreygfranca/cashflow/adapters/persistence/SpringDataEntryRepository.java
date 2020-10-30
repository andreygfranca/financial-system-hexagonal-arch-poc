package com.github.andreygfranca.cashflow.adapters.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.andreygfranca.cashflow.core.domain.Entry;

/**
 * @author Andrey Franca 
 */
@Repository
public interface SpringDataEntryRepository extends JpaRepository<Entry, UUID> {
}
