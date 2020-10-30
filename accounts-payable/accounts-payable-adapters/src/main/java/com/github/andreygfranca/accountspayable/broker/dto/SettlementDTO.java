package com.github.andreygfranca.accountspayable.broker.dto;

import java.math.BigDecimal;

/**
 * @author Andrey Franca 
 */
public class SettlementDTO {
    private String id;
    private BigDecimal value;
    private String accountPayableId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getAccountPayableId() {
        return accountPayableId;
    }

    public void setAccountPayableId(String accountPayableId) {
        this.accountPayableId = accountPayableId;
    }


    public static final class Builder {
        private SettlementDTO settlementDTO;

        private Builder() {
            settlementDTO = new SettlementDTO();
        }

        public static Builder of() {
            return new Builder();
        }

        public Builder id(String id) {
            settlementDTO.setId(id);
            return this;
        }

        public Builder value(BigDecimal value) {
            settlementDTO.setValue(value);
            return this;
        }

        public Builder accountPayableId(String accountPayableId) {
            settlementDTO.setAccountPayableId(accountPayableId);
            return this;
        }

        public SettlementDTO build() {
            return settlementDTO;
        }
    }
}
