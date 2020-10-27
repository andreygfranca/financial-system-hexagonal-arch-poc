package com.github.andreygfranca.accountspayable.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Andrey Franca 
 */
@Entity
@Table(name = "t_account_payable")
public class AccountPayable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Column(name = "en_type")
    @Enumerated(EnumType.ORDINAL)
    private AccountPayableType type;

    @Column(name = "vl_account_payable")
    private BigDecimal value;

    @Column(name = "dt_maturity")
    private LocalDate maturityDate;

    @Column(name = "ds_observation")
    private String observation;

    @OneToMany(mappedBy = "accountPayableId")
    private List<Settlement> settlement = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AccountPayableType getType() {
        return type;
    }

    public void setType(AccountPayableType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public List<Settlement> getSettlement() {
        return settlement;
    }

    public void setSettlement(List<Settlement> settlement) {
        this.settlement = settlement;
    }
}
