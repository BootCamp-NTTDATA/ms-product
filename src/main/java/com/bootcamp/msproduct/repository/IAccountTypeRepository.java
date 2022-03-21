package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.AccountType;
import com.bootcamp.msproduct.service.AccountTypeServiceImpl;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IAccountTypeRepository extends ReactiveMongoRepository<AccountType, String> {
    Mono<AccountType> findByName(String name);
}
