package com.bootcamp.msproduct.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DebitCardDto {
    private String id;
    private String Name;
    private BigDecimal interestRateMonth;
    private int numberMovementDay;
    private String clientType;
}