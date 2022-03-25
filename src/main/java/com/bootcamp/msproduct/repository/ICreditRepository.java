package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends ReactiveMongoRepository<Credit,String> {
}
