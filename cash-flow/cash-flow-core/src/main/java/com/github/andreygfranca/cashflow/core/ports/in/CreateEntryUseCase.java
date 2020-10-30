package com.github.andreygfranca.cashflow.core.ports.in;

import com.github.andreygfranca.cashflow.core.domain.Entry;

/**
 * @author Andrey Franca 
 */
public interface CreateEntryUseCase {
    Entry create(Entry entry);
}
