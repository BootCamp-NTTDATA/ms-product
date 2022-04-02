package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Wallet extends BaseEntity{
    private BigDecimal maxAmountMovement;
    private String type;
}
