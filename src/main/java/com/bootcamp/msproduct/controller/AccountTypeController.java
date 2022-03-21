package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.AccountTypeDto;
import com.bootcamp.msproduct.resource.AccountTypeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account-type")
public class AccountTypeController {

    @Autowired
    private AccountTypeResource accountTypeResource;

    @PostMapping
    public Mono<AccountTypeDto> create(@RequestBody AccountTypeDto accountDto) {
        return accountTypeResource.create(accountDto);
    }

    @PutMapping
    public Mono<AccountTypeDto> update(@RequestBody AccountTypeDto accountDto) {
        return accountTypeResource.update(accountDto);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody AccountTypeDto accountDto) {
        return accountTypeResource.delete(accountDto);
    }

    @GetMapping
    public Flux<AccountTypeDto> findAll() {
        return accountTypeResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AccountTypeDto> findById(@PathVariable String id) {
        return accountTypeResource.findById(id);
    }

    @GetMapping("/name/{name}")
    public Mono<AccountTypeDto> findByName(@PathVariable String name) {
        return accountTypeResource.findByName(name);
    }
}
