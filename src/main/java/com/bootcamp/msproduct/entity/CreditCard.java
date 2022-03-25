package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditCard extends BaseEntity{
    private String type;
    private BigDecimal limit;
    private BigDecimal interestRateMonth;
    private Boolean allowCompany;
    private Boolean allowPerson;
}
