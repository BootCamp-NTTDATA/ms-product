package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard extends BaseEntity{
    private String name;
    private String clientType;
}
