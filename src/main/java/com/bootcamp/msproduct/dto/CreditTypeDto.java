package com.bootcamp.msproduct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditTypeDto {
    private String id;
    private String name;
    private String code;
    private String ClientType;
    private Float maximumRate;
    private Float minimumRate;
    private Float creditMaximumAmount;
    private Float creditMinimumAmount;
}
