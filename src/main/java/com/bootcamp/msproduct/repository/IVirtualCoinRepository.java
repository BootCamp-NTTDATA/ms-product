package com.bootcamp.msproduct.repository;

import com.bootcamp.msproduct.entity.VirtualCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IVirtualCoinRepository extends ReactiveMongoRepository<VirtualCoin, String> {
}
