package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Account;
import com.bootcamp.msproduct.util.ICrud;
import reactor.core.publisher.Mono;

public interface IAccountService extends ICrud<Account, String> {
    Mono<Account> findByType(String type);
}
