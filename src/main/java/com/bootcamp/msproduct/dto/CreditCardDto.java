package com.bootcamp.msproduct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDto {
    private String id;
    private String type;
    private BigDecimal limit;
    private BigDecimal interestRateMonth;
    private Boolean allowCompany;
    private Boolean allowPerson;
}