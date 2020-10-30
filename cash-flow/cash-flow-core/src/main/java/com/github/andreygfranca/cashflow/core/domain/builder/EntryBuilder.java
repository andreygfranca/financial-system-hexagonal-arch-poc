package com.github.andreygfranca.cashflow.core.domain.builder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.andreygfranca.cashflow.core.domain.Classification;
import com.github.andreygfranca.cashflow.core.domain.Entry;

/**
 * @author Andrey Franca 
 */
public final class EntryBuilder {
    private Entry entry;

    private EntryBuilder() {
        entry = new Entry();
    }

    public static EntryBuilder anEntry() {
        return new EntryBuilder();
    }

    public EntryBuilder withId(UUID id) {
        entry.setId(id);
        return this;
    }

    public EntryBuilder withEntryDate(LocalDateTime entryDate) {
        entry.setEntryDate(entryDate);
        return this;
    }

    public EntryBuilder withSettlementId(String settlementId) {
        entry.setSettlementId(settlementId);
        return this;
    }

    public EntryBuilder withClassification(Classification classification) {
        entry.setClassification(classification);
        return this;
    }

    public EntryBuilder withPaymentDate(LocalDateTime paymentDate) {
        entry.setPaymentDate(paymentDate);
        return this;
    }

    public Entry build() {
        return entry;
    }
}
