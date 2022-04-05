package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DebitCard extends BaseEntity{
    private String Name;
    private BigDecimal interestRateMonth;
    private int numberMovementDay;
    private String clientType;
}