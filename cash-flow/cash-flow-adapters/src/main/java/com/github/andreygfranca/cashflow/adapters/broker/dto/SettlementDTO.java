package com.github.andreygfranca.cashflow.adapters.broker.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Andrey Franca 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public String toString() {
        return "SettlementDTO{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", accountPayableId='" + accountPayableId + '\'' +
                '}';
    }
}
