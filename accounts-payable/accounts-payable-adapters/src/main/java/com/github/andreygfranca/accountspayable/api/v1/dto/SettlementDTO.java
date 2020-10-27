package com.github.andreygfranca.accountspayable.api.v1.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Andrey Franca 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlementDTO {

    private String id;
    private BigDecimal value;
    private AccountPayableDTO accountPayable;

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

    public AccountPayableDTO getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(AccountPayableDTO accountPayable) {
        this.accountPayable = accountPayable;
    }
}
