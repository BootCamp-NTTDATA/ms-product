package com.bootcamp.msproduct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDto {
    private String id;
    private BigDecimal maxAmountMovement;
    private String type;
}
