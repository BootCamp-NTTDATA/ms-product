package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Account;
import com.bootcamp.msproduct.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    public Mono<Account> save(Account account) {
        return iAccountRepository.save(account);
    }

    public Mono<Void> deleteById(String id) {
        return iAccountRepository.deleteById(id);
    }

    public Flux<Account> findAll() {
        return iAccountRepository.findAll();
    }

    public Mono<Account> findByType(String type) {
        return iAccountRepository.findByType(type);
    }

    public Mono<Account> findById(String id) {
        return iAccountRepository.findById(id);
    }
}
