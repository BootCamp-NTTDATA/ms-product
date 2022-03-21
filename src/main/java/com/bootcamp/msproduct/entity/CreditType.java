package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditType extends BaseEntity{
    private String name;
    private String code;
    private String ClientType;
    private Float maximumRate;
    private Float minimumRate;
    private Float creditMaximumAmount;
    private Float creditMinimumAmount;
}
