package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.AccountType;
import com.bootcamp.msproduct.repository.IAccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTypeServiceImpl implements IAccountTypeService {

    @Autowired
    private IAccountTypeRepository iAccountTypeRepository;

    public Mono<AccountType> save(AccountType accountType) {
        return iAccountTypeRepository.save(accountType);

    }

    public Mono<Void> deleteById(String id) {
        return iAccountTypeRepository.deleteById(id);
    }

    public Flux<AccountType> findAll() {
        return iAccountTypeRepository.findAll();
    }

    public Mono<AccountType> findByName(String name) {
        return iAccountTypeRepository.findByName(name);
    }

    public Mono<AccountType> findById(String id) {
        return iAccountTypeRepository.findById(id);
    }
}
