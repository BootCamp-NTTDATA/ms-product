package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VirtualCoin extends BaseEntity{
    private String code;
    private String name;
    private String abbreviation;
}
