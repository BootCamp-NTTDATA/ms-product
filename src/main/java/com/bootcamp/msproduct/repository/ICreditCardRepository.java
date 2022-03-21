package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
    Flux<CreditCard> findByClientType(String clientType);
    Mono<CreditCard> findByName(String name);
}
