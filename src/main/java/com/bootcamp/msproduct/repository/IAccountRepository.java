package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IAccountRepository extends ReactiveMongoRepository<Account, String> {
    Mono<Account> findByType(String type);
}
