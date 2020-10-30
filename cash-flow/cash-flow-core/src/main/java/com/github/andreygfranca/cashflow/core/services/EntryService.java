package com.github.andreygfranca.cashflow.core.services;

import org.springframework.stereotype.Service;

import com.github.andreygfranca.cashflow.core.domain.Entry;
import com.github.andreygfranca.cashflow.core.ports.in.CreateEntryUseCase;
import com.github.andreygfranca.cashflow.core.ports.out.CreateEntryPort;

/**
 * @author Andrey Franca 
 */
@Service
public class EntryService implements CreateEntryUseCase {

    private CreateEntryPort createEntryPort;

    @Override
    public Entry create(Entry entry) {
        return createEntryPort.create(entry);
    }
}
