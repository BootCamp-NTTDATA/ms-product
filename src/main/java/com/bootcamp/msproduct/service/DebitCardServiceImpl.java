package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.DebitCard;
import com.bootcamp.msproduct.repository.IDebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitCardServiceImpl implements IDebitCardService{
    @Autowired
    private IDebitCardRepository debitCardRepository;
    @Override
    public Mono<DebitCard> save(DebitCard debitCard) {
        return debitCardRepository.save(debitCard);
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return debitCardRepository.deleteById(id);
    }
    @Override
    public Mono<DebitCard> findById(String id) {
        return debitCardRepository.findById(id);
    }
    @Override
    public Flux<DebitCard> findAll() {
        return debitCardRepository.findAll();
    }
}
