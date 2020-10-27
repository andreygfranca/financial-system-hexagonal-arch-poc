package com.github.andreygfranca.accountspayable.api.v1.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Andrey Franca 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountPayableDTO {
    private String id;
    private String type;
    private BigDecimal value;

    public AccountPayableDTO(String id, String type, BigDecimal value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
