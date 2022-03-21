package com.bootcamp.msproduct.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountType  extends BaseEntity{
    private String name;
    private Float maintenanceCommission;
    private Integer maxMonthlyMovements;
    private Integer uniqueMovementDay;
    private Integer maxPerClient;
    private String clientType;
}
