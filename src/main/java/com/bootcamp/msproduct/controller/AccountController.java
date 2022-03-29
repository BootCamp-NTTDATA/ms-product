package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.AccountDto;
import com.bootcamp.msproduct.resource.AccountResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product/account")
public class AccountController {

    @Autowired
    private AccountResource accountResource;

    @PostMapping
    public Mono<AccountDto> create(@RequestBody AccountDto accountDto) {
        return accountResource.create(accountDto);
    }

    @PutMapping
    public Mono<AccountDto> update(@RequestBody AccountDto accountDto) {
        return accountResource.update(accountDto);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody AccountDto accountDto) {
        return accountResource.delete(accountDto);
    }

    @GetMapping
    public Flux<AccountDto> findAll() {
        return accountResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AccountDto> findById(@PathVariable String id) {
        return accountResource.findById(id);
    }

    @GetMapping("/type/{type}")
    public Mono<AccountDto> findByType(@PathVariable String type) {
        return accountResource.findByType(type);
    }
}
