package com.bootcamp.msproduct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDto {
    private String id;
    private String name;
    private String clientType;
}