package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account extends BaseEntity{
    private BigDecimal maintenanceCommission;
    private BigDecimal transactionCommission;
    private BigDecimal minimumOpeningAmount;
    private int numLimitMovements;
    private String type;
    private int dayMovement;
    private Boolean allowCompany;
    private Boolean allowPerson;
    private Boolean needCreditCard;
}
