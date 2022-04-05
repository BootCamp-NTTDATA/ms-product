package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.DebitCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IDebitCardRepository extends ReactiveMongoRepository<DebitCard, String> {
}
