package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Credit;
import com.bootcamp.msproduct.entity.CreditCard;
import com.bootcamp.msproduct.util.ICrud;
import reactor.core.publisher.Mono;

public interface ICreditService extends ICrud<Credit, String> {
    Mono<Credit> findByType(String type);
}
