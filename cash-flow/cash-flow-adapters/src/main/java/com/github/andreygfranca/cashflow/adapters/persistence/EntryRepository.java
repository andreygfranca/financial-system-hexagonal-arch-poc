package com.github.andreygfranca.cashflow.adapters.persistence;

import org.springframework.stereotype.Component;

import com.github.andreygfranca.cashflow.core.domain.Entry;
import com.github.andreygfranca.cashflow.core.ports.out.CreateEntryPort;

/**
 * @author Andrey Franca 
 */
@Component
public class EntryRepository implements CreateEntryPort {

    private final SpringDataEntryRepository springDataEntryRepository;

    public EntryRepository(SpringDataEntryRepository springDataEntryRepository) {
        this.springDataEntryRepository = springDataEntryRepository;
    }

    @Override
    public Entry create(Entry entry) {
        return springDataEntryRepository.save(entry);
    }
}
