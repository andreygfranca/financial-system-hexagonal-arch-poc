package com.github.andreygfranca.cashflow.core.ports.out;

import com.github.andreygfranca.cashflow.core.domain.Entry;

/**
 * @author Andrey Franca 
 */
public interface CreateEntryPort {
    Entry create(Entry entry);
}
