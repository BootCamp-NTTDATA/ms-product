package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IWalletRepository extends ReactiveMongoRepository<Wallet, String> {
    Mono<Wallet> findByType(String type);
}
