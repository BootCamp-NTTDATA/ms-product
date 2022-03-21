package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.CreditType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditTypeRepository extends ReactiveMongoRepository<CreditType,String> {
}
