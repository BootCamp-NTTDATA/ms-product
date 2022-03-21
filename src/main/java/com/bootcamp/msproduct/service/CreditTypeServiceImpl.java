package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.CreditType;
import com.bootcamp.msproduct.repository.ICreditTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditTypeServiceImpl implements ICreditTypeService{
    @Autowired
    ICreditTypeRepository iCreditTypeRepository;

    @Override
    public Mono<CreditType> save(CreditType creditType) {
        return iCreditTypeRepository.save(creditType);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCreditTypeRepository.deleteById(id);
    }

    @Override
    public Mono<CreditType> findById(String id) {
        return iCreditTypeRepository.findById(id);
    }

    @Override
    public Flux<CreditType> findAll() {
        return iCreditTypeRepository.findAll();
    }
}
