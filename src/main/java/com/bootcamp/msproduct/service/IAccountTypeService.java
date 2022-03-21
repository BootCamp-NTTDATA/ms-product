package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.AccountType;
import com.bootcamp.msproduct.util.ICrud;
import reactor.core.publisher.Mono;

public interface IAccountTypeService extends ICrud<AccountType, String> {
    Mono<AccountType> findByName(String name);
}
