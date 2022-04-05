package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Wallet;
import com.bootcamp.msproduct.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private IWalletRepository iWalletRepository;

    @Override
    public Mono<Wallet> save(Wallet wallet) {
        return iWalletRepository.save(wallet);
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return iWalletRepository.deleteById(s);
    }

    @Override
    public Mono<Wallet> findById(String s) {
        return iWalletRepository.findById(s);
    }

    @Override
    public Flux<Wallet> findAll() {
        return iWalletRepository.findAll();
    }
}
