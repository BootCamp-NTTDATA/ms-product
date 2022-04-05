package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.VirtualCoin;
import com.bootcamp.msproduct.repository.IVirtualCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VirtualCoinServiceImpl  implements IVirtualCoinService{
    @Autowired
    IVirtualCoinRepository virtualCoinRepository;
    @Override
    public Mono<VirtualCoin> save(VirtualCoin virtualCoin) {
        return virtualCoinRepository.save(virtualCoin);
    }
    @Override
    public Mono<Void> deleteById(String s) {
        return virtualCoinRepository.deleteById(s);
    }
    @Override
    public Mono<VirtualCoin> findById(String s) {
        return virtualCoinRepository.findById(s);
    }
    @Override
    public Flux<VirtualCoin> findAll() {
        return virtualCoinRepository.findAll();
    }
}