package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.Credit;
import com.bootcamp.msproduct.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICreditRepository extends ReactiveMongoRepository<Credit,String> {
    Mono<Credit> findByType(String type);
}
