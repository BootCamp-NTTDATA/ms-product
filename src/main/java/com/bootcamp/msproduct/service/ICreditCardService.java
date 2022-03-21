package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.CreditCard;
import com.bootcamp.msproduct.util.ICrud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditCardService extends ICrud<CreditCard,String> {

    Flux<CreditCard> findByClientType(String clientType);
    Mono<CreditCard> findByName(String name);
}
