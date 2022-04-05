package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Credit;
import com.bootcamp.msproduct.entity.CreditCard;
import com.bootcamp.msproduct.repository.ICreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {
    @Autowired
    private ICreditRepository iCreditRepository;

    @Override
    public Mono<Credit> save(Credit credit) {
        return iCreditRepository.save(credit);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCreditRepository.deleteById(id);
    }

    @Override
    public Mono<Credit> findById(String id) {
        return iCreditRepository.findById(id);
    }

    @Override
    public Flux<Credit> findAll() {
        return iCreditRepository.findAll();
    }

    @Override
    public Mono<Credit> findByType(String type) {
        return iCreditRepository.findByType(type);
    }
}
