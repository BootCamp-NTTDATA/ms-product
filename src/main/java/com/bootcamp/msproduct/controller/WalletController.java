package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.WalletDto;
import com.bootcamp.msproduct.resource.WalletResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product/wallet")
public class WalletController {

    @Autowired
    private WalletResource walletResource;

    @PostMapping
    public Mono<WalletDto> create(@RequestBody WalletDto walletDto){
        return walletResource.create(walletDto);
    }

    @PutMapping
    public Mono<WalletDto> update(@RequestBody WalletDto walletDto) {
        return walletResource.update(walletDto);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody WalletDto walletDto) {
        return walletResource.delete(walletDto);
    }

    @GetMapping
    public Flux<WalletDto> findAll() {
        return walletResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<WalletDto> findById(@PathVariable String id) {
        return walletResource.findById(id);
    }
}
